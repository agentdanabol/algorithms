package YANDEX_MITAP_1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Solution {

    public static void main(String[] args) {
        try {
            cockteil("src/YANDEX_MITAP_1/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cockteil(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String[] lineArray = bufferedReader.readLine().split(" ");

            int n = Integer.parseInt(lineArray[0]);
            int m = Integer.parseInt(lineArray[1]);
            int size = n * m + n;
            char[] charBuf = new char[size];

            bufferedReader.read(charBuf, 0, size);
            String result = String.copyValueOf(charBuf, 0, size);

            int k = Integer.parseInt(bufferedReader.readLine());
            int temp = 0;
            ++m;

            for(int j = k; j > 0; --j) {
                String[] split = bufferedReader.readLine().split(" ");
                int count = Integer.parseInt(split[1]);
                String symbol = split[2];

                for(int i = m * (n - temp - 1 ) - 1; i >= ((n-1- count - temp) * m); --i) {
                    if(result.charAt(i) == ' ') {
                        result = result.substring(0, i) + symbol + result.substring(i + 1);
                    }
                }
                temp += count;
            }
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
