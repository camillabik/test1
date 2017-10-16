package classCode.consolFileEditor;

import java.io.*;

public class ConsoleEditor implements Editor{
    private final String FILE_NAME = "1.txt";

    @Override
    public String read() {
        StringBuilder resalt =new StringBuilder("");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resalt.append(line);
                resalt.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found:" + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Some IO Exception");
        }

        return String.valueOf(resalt);
    }


    @Override
    public void write(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Some IO Exception");
        }
    }

    @Override
    public void append(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Some IO Exception");
        }
    }

    public static void main(String[] args) {
        ConsoleEditor consoleEditor = new ConsoleEditor();


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            //String input = bufferedReader.readLine();
            String input = "go";
            while (!input.equals("exit") /*true*/) {

                System.out.println("enter command:");
                input = bufferedReader.readLine();
                switch (input) {
                    case "read":
                        consoleEditor.read();
                        break;

                    case "write":
                        System.out.println("Please enter text to write:");
                        String text = bufferedReader.readLine();
                        consoleEditor.write(text);
                        break;

                    case "append":
                        System.out.println("Please enter text to append:");
                        String textToAppend = bufferedReader.readLine();
                        consoleEditor.append(System.lineSeparator() + textToAppend);
                        break;
                    default:
                        input = "exit";
                }
            }

        } catch (IOException e) {
            System.out.println("Some IO Exception :-(");
        }

    }
}
