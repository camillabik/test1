package classCode.сhat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> o : connectionMap.entrySet()) {
            try {
                o.getValue().send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler extends Thread
    {
        Socket socket;
        Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            String clientName;
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    clientName = message.getData();
                    if (clientName.isEmpty()) continue;
                    if (connectionMap.containsKey(clientName))continue;
                    break;
                }
            }
            connectionMap.put(clientName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return clientName;
        }


        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (String name: connectionMap.keySet()) {
                if (!name.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String mas = userName +": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, mas));
                }
                else
                {
                    ConsoleHelper.writeMessage("Ошибка");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с "+ socket.getRemoteSocketAddress());
            Connection connection = null;
            String clientName = null;

            try {
                connection= new Connection(socket);
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection,clientName);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if (clientName != null)
                {
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                }
                ConsoleHelper.writeMessage("Cоединение с удаленным адресом закрыто");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)){

            ConsoleHelper.writeMessage("Cервер запущен");

            while (true)
            {
                Socket socket =serverSocket.accept();
                Handler handler= new Handler(socket);
                handler.start();

            }
        }catch (Exception e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}

