package yandex_internship_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_internship_4/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            int N =  Integer.parseInt(bufferedReader.readLine());
            String[] minIncome = bufferedReader.readLine().split(" ");
            String[] needEdu = bufferedReader.readLine().split(" ");
            String[] childPermit = bufferedReader.readLine().split(" ");

            int Q =  Integer.parseInt(bufferedReader.readLine());
            String[] income = bufferedReader.readLine().split(" ");
            String[] edu = bufferedReader.readLine().split(" ");
            String[] country = bufferedReader.readLine().split(" ");

            List<Integer> resultList = new ArrayList<>();
            for(int i = 0; i < Q; i++) {
                List<Integer> countries = new ArrayList<>();
                for(int j = 0; j < N; j++) {
                    if(childPermit[j].equals("1") && Integer.parseInt(country[i]) == j+1) {
                        countries.add(j+1);
                    }
                    else if(Integer.parseInt(income[i]) >= Integer.parseInt(minIncome[j])) {
                        if(needEdu[j].equals("1") && edu[i].equals("1")){
                            countries.add(j+1);
                        }
                        else if(needEdu[j].equals("0")) {
                            countries.add(j+1);
                        }
                    }
                }
                if(countries.isEmpty()) {
                    resultList.add(0);
                }
                else {
                    resultList.add(countries.get(0));
                }
            }

            resultList.forEach(e -> System.out.print(e + " "));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
