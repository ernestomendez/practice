package com.dxesoft.cracking;

import java.util.HashMap;
import java.util.Map;

public class KidnapNote {

    private Map<String, Integer> magazineMap = new HashMap<>();

    public boolean isDuplicable(String magazine, String note) {
        boolean isDuplicable = true;

        if (note.length() < magazine.length()) {

            countWords(magazine);

            String[] noteWords = note.split(" ");


            for (String word : noteWords) {
                if (!removeWord(word)) {
                    isDuplicable = false;
                    break;
                }
            }
        }

        return isDuplicable;

    }

    private void countWords(String magazine) {
        String[] words = magazine.split(" ");

        for (String word : words) {

            magazineMap.merge(word, 1, (a, b) -> a + b);
        }
    }

    private boolean removeWord(String word) {

        Integer count = magazineMap.get(word);

        boolean removed = false;

        if ((null != count) && (count > 0)) {
            magazineMap.put(word, --count);
            removed = true;
        }

        return removed;

    }
}

//
//
//    private static Map<String, Integer> magazineMap = new HashMap<>();
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        String magazine[] = new String[m];
//        for(int magazine_i=0; magazine_i < m; magazine_i++){
//            magazine[magazine_i] = in.next();
//        }
//        String ransom[] = new String[n];
//        for(int ransom_i=0; ransom_i < n; ransom_i++){
//            ransom[ransom_i] = in.next();
//        }
//
//        boolean answer = isDuplicable(magazine, ransom);
//        if(answer)
//            System.out.println("Yes");
//        else System.out.println("No");
//    }
//
//    public static boolean isDuplicable(String[] magazine, String[] note) {
//        boolean isDuplicable = true;
//
//        if (note.length < magazine.length) {
//
//            countWords(magazine);
//
//            for (String word : note) {
//                if (!removeWord(word)) {
//                    isDuplicable = false;
//                    break;
//                }
//            }
//        }
//
//        return isDuplicable;
//    }
//
//    private static void countWords(String[] magazine) {
//        for (String word : magazine) {
//
//            magazineMap.merge(word, 1, (a, b) -> a + b);
//        }
//    }
//
//    private static boolean removeWord(String word) {
//
//        Integer count = magazineMap.get(word);
//
//        boolean removed = false;
//
//        if ((null != count) && (count > 0)) {
//            magazineMap.put(word, --count);
//            removed = true;
//        }
//
//        return removed;
//
//    }
//}