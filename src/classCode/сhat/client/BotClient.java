package classCode.сhat.client;

import classCode.сhat.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{


    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message!=null&&!message.isEmpty()&&message.contains(": "))
            {
                String nameUse = message.substring(0, message.indexOf(":"));
                String text = message.substring(message.indexOf(":")+2);
                SimpleDateFormat dataForm = null;
                switch (text) {
                    case "дата":
                        dataForm = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dataForm = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dataForm = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dataForm = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dataForm = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dataForm = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dataForm = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dataForm = new SimpleDateFormat("ss");
                        break;

                }
                if (dataForm!=null)
                    sendTextMessage(String.format("Информация для %s: %s", nameUse, dataForm.format(Calendar.getInstance().getTime())));

            }

        }


    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
