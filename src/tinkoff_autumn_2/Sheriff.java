package tinkoff_autumn_2;

import java.util.*;

public class Sheriff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        List<Character> letters = new ArrayList<>(Arrays.asList('s', 'h', 'e', 'r', 'i', 'f', 'f'));

        List<List<Character>> wordsList = new ArrayList<>();
        wordsList.add(new ArrayList<>());
        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if(letters.contains(sym)){
                boolean success = false;
                for (List<Character> word : wordsList) {
                    if (!word.contains(sym)) {
                        word.add(sym);
                        success = true;
                        break;
                    } else if (sym == 'f') {
                        long count = word.stream().filter(letter -> letter == 'f').count();
                        if (count < 2) {
                            word.add(sym);
                            success = true;
                            break;
                        }
                    }
                }
                if (!success){
                    wordsList.add(new ArrayList<>(Collections.singleton(sym)));
                }
            }
        }

        long count = wordsList.stream().filter(word -> word.size() == 7).count();
        System.out.println(count);
    }

}
