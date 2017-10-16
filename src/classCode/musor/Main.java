package classCode.musor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static Map<Object, Object> cache = new HashMap<Object, Object>();

    public static void main(String[] args) {
        System.out.println("Waiting for command");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

//        switch (command){
//            case "1":
//                createLeakable();
//            case "c":
//
//
//        }

    }
   // static List<String> createBig

    static void createCollectale(){
        Map<Object, Object> localCache = new HashMap<Object, Object>();
        for (int i = 0; i < 1_000_00; i++) {

        }
    }


}
