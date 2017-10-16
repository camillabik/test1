package fileEditor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileEditor {
    static  Map<String, Integer> wordsCount = new HashMap<>();
    static volatile boolean flag = false;
    public static void main(String[] args) {
//        List<String> paths = new ArrayList<>();
//        paths.add("C:\\Users\\admin\\IdeaProjects\\test1\\src\\fileEditor\\1.txt");
//        paths.add("C:\\Users\\admin\\IdeaProjects\\test1\\src\\fileEditor\\2.txt");
//        paths.add("C:\\Users\\admin\\IdeaProjects\\test1\\src\\fileEditor\\3.txt");
//        paths.add("C:\\Users\\admin\\IdeaProjects\\test1\\src\\fileEditor\\4.txt");

        for (int i = 0; i < args.length; i++) {
            if (flag)return;
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    File file = new File(args[finalI]);
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                        while (((line = reader.readLine()) != null)&&(!flag)) {

                            line = line.replaceAll("[\\p{P}]", "");
                            String[] arr = line.split("[\\s+]");
                            for (int j = 0; j < arr.length; j++) {
                                String word = arr[j];
                                if (word.matches("[A-Za-z]"))
                                {
                                    flag = true;
                                    return;
                                }
                                if ((word.matches("[\\d+\\W]")) || (word.isEmpty())) continue;


                                synchronized (wordsCount) {
                                    if (wordsCount.containsKey(word)) {
                                        wordsCount.put(word, wordsCount.get(word) + 1);
                                        System.out.println("количество вхождений слова: \"" + word + "\" " + wordsCount.get(word) + " раз(а)");
                                    } else {
                                        wordsCount.put(arr[j], 1);
                                        System.out.println("новое слово слово: \"" + word + "\" ");
                                    }
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-"+i);
        }


    }



}
