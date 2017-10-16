package classCode.сhat.client;



import classCode.сhat.Connection;
import classCode.сhat.ConsoleHelper;
import classCode.сhat.Message;
import classCode.сhat.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адресс сервера:");
        return ConsoleHelper.readString();
    }
    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }
    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }
    protected void sendTextMessage(String text)
    {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        }catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения. Соединение будет закрыто.");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Ошибка");
                return;
            }

        }
        if (clientConnected)

            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду \"exit\".");

        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected)
        {
            String s = ConsoleHelper.readString();
            if (s.toLowerCase().equals("exit"))break;
            if (shouldSendTextFromConsole())
                sendTextMessage(s);
        }


    }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }
        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    Message m = new Message(MessageType.USER_NAME, getUserName());
                    connection.send(m);
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }

        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run()
        {
            String sa = getServerAddress();
            int port = getServerPort();
            try {
                Socket soc = new Socket(sa, port);
                connection = new Connection(soc);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }


        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}

