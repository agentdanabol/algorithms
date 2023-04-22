package YANDEX_MITAP_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        solve("src/YANDEX_MITAP_2/input.txt");
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            String[] str = line.split(" ");
            int n = Integer.parseInt(String.valueOf(str[0]));
            int m = Integer.parseInt(String.valueOf(str[1]));

            line = bufferedReader.readLine();
            List<Long> plates = new ArrayList<>();
            String[] split = line.split(" ");
            for(int i = 0; i < n; i++) {
                plates.add(Long.parseLong(split[i]));
            }
            line = bufferedReader.readLine();
            List<Long> guards = new ArrayList<>();
            split = line.split(" ");
            for(int i = 0; i < m; i++) {
                guards.add(Long.parseLong(split[i]));
            }

            List<Long> temp = new ArrayList<>();
            temp.add(plates.get(n-1));
            Long cover = plates.get(n-1);

            for(int i = n-2; i >= 0; i--) {
                if(plates.get(i) > cover) {
                    temp.add(0, plates.get(i)-cover);
                    cover = plates.get(i);
                }
            }

            Long result = 0L;
            Collections.sort(temp);

            for (Long aLong : temp) {
                for (Long guard : guards) {
                    if (aLong >= guard) {
                        result++;
                        guards.remove(guard);
                        break;
                    }
                }
            }

            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
