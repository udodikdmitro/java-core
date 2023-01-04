package map;

import java.util.*;

public class MapLauncher {

    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] tokens = string.split(" ");

        for(String token: tokens){
            String word = token.toLowerCase();
            Integer count = wordMap.get(word);
            if(count == null){
                wordMap.put(word,1);
            } else {
                wordMap.put(word,count + 1);
            }
        }
        printMap(wordMap);
    }

    private static void printMap(Map<String, Integer> wordMap) {
        Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
        Set<String> keys = wordTreeMap.keySet();

        for(String key: keys){
//            System.out.println("%-10s%-10s \n", key, wordMap.get(key));
        }
    }
}
