package yandex_internship_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_internship_5/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String[] firstLine = bufferedReader.readLine().split(" ");
            int N =  Integer.parseInt(firstLine[0]);
            int K =  Integer.parseInt(firstLine[1]);
            String str = bufferedReader.readLine();
            List<Integer> positions = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> shift = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}