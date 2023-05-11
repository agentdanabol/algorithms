package tinkoff_task_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        String line = scanner.next();

        List<String> substrings = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            String alf = "abcd";
            for(int j = i; j < n; j++) {
                if(alf.indexOf(line.charAt(j)) != -1) {
                    alf = alf.replace(line.charAt(j), ' ');
                }
                temp.append(line.charAt(j));
                alf = alf.replaceAll(" ", "");
                if(alf.isEmpty()) {
                    substrings.add(temp.toString());
                    break;
                }
            }
        }

        Optional<String> res = substrings.stream().min(Comparator.comparingInt(String::length));
        if(res.isEmpty()) {
            System.out.println(-1);
        }
        else {
            System.out.println(res.get().length());
        }

    }

}
