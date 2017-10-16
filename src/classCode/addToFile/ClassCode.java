package classCode.addToFile;

import java.io.*;
import java.util.ArrayList;

public class ClassCode
{


    public static void writeToFile(){

        try(FileWriter fileWriter = new FileWriter("1.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("hello");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readByFile(){
        try(FileReader fileReader = new FileReader("1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void append(){

        String path = "1.txt";
        try( RandomAccessFile file = new RandomAccessFile(path, "rw")) {

            file.seek(file.length()); //установдиваем курсов в конец файла
            file.write("hi-hi".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendString(int namStr){

        String path = "1.txt";
        String writeStr = "hi-hi-hi-hi!";
        String line;
        ArrayList<String> array = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             RandomAccessFile file = new RandomAccessFile(path, "rw")
        ){

            while ((line = reader.readLine()) != null) {
                array.add(line);

            }

            if (namStr>array.size())//если сторок в файле меньше, чем переданное в параметр число, установдиваем курсов в конец файла
            {
                file.seek(file.length());
                file.write(writeStr.getBytes());
            }
            else
            {
                for (int i = 0; i < array.size(); i++) {
                    if (i==(namStr-1))
                    {
                        file.write(writeStr.getBytes());
                        file.write("\n".getBytes());
                    }
                    file.write(array.get(i).getBytes());
                    file.write("\n".getBytes());

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
//        writeToFile();
//        readByFile();
        //       append();
        //     appendString(2);
     //   appendString(8);



    }
}
