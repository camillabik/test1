package fe;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileEditorTo extends Thread{
    private Map<String, Integer> wordsCount = new HashMap<>();
    volatile boolean flag = false;
    List<Thread> threads = new ArrayList<>();
    String puth;
    public FileEditorTo(String puth)
    {
        this.puth = puth;
    }

    @Override
    public void run() {
        File file = new File(puth);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (((line = reader.readLine()) != null) && (!flag)) {
                parsingStrMetod(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void parsingStrMetod(String line)
    {
        line = line.replaceAll("[\\p{P}]", "");
        String[] arr = line.split("[\\s+]");
        String word = null;
        for (int j = 0; j < arr.length; j++) {
            word = arr[j];
            String str =  controlChar(word);
            wordCountMethod(str);
        }
    }

    public String controlChar(String word) {
        if (word.matches("[A-Za-z]")) {
            flag = true;
            return "";
        }
        if ((word.matches("\\d+"))||(word.matches("[\\W+]")) || (word.isEmpty())) return "";
        else return word;
    }

    void wordCountMethod(String word)
    {
        synchronized (wordsCount) {
            if (word.isEmpty())return;
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
                System.out.println("количество вхождений слова: \"" + word + "\" " + wordsCount.get(word) + " раз(а)");
            } else {
                wordsCount.put(word, 1);
                System.out.println("новое слово слово: \"" + word + "\" ");
            }
        }
    }

    public Map<String, Integer> getWordsCount() {
        return wordsCount;
    }
}
