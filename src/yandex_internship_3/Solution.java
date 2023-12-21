package yandex_internship_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_internship_3/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            int N =  Integer.parseInt(bufferedReader.readLine());
            String[] line = bufferedReader.readLine().split(" ");
            int[] prices = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

            int lsf = Integer.MAX_VALUE;
            int op = 0;
            int pist = 0;

            for(int i = 0; i < prices.length; i++){
                if(prices[i] < lsf){
                    lsf = prices[i];
                }
                pist = prices[i] - lsf;
                if(op < pist){
                    op = pist;
                }
            }
            System.out.println(op);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
