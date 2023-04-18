package yandex_internship_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_internship_1/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            int N =  Integer.parseInt(bufferedReader.readLine());
            String[] symbols = bufferedReader.readLine().split(" ");
            String[] row = bufferedReader.readLine().split(" ");

            Map<String, String> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                map.put(symbols[i], row[i]);
            }

            int K =  Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");

            int result = 0;
            for(int i = 0; i < K-1; i++) {
                String current = map.get(input[i]);
                String next = map.get(input[i+1]);
                if(!current.equals(next)) {
                    result ++;
                }
            }

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
