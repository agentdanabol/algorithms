package yandex_internship_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_internship_2/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String[] line = bufferedReader.readLine().split(" ");
            int N =  Integer.parseInt(line[0]);
            int X =  Integer.parseInt(line[1]);
            int T =  Integer.parseInt(line[2]);

            String[] sculp = bufferedReader.readLine().split(" ");

            Map<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < N; i++) {
                int mod = Math.abs(X - Integer.parseInt(sculp[i]));
                map.put(mod, i);
            }

            int capacity = 0;
            int count = 0;
            List<Integer> resultList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
                capacity += pair.getKey();
                if(capacity >= T) {
                    break;
                }
                count ++;
                resultList.add(pair.getValue() + 1);
            }

            System.out.println(count);
            resultList.forEach(e -> System.out.print(e + " "));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
