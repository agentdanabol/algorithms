package yandex_academy_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            solve("src/yandex_academy_1/input.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solve(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            String[] firstLine = bufferedReader.readLine().split(" ");
            int n =  Integer.parseInt(firstLine[0]);
            int m =  Integer.parseInt(firstLine[1]);
            int q =  Integer.parseInt(firstLine[2]);

            List<List<Boolean>> data = new ArrayList<>();
            Map<Integer, Integer> resets = new HashMap<>();
            for(int i = 0; i < n; i++) {
                data.add(new ArrayList<>());
                for(int j = 0; j < m; j++) {
                    data.get(i).add(true);
                    resets.put(i, 0);
                }
            }

            for(int i = 0; i < q; i++) {
                String[] line = bufferedReader.readLine().split(" ");
                switch (line[0]) {
                    case "DISABLE" -> {
                        List<Boolean> servers1 = data.get(Integer.parseInt(line[1])-1);
                        servers1.remove(Integer.parseInt(line[2])-1);
                        servers1.add(Integer.parseInt(line[2])-1, false);
                    }
                    case "RESET" -> {
                        List<Boolean> servers2 = data.get(Integer.parseInt(line[1])-1);
                        int size = servers2.size();
                        servers2.clear();
                        for(int j = 0; j < size; j++){
                            servers2.add(true);
                        }
                        int count = resets.get(Integer.parseInt(line[1])-1);
                        resets.put(Integer.parseInt(line[1])-1, count+1);
                    }
                    case "GETMAX" -> {
                        System.out.println(getMax(data, resets));
                    }
                    case "GETMIN" -> {
                        System.out.println(getMin(data, resets));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getMax(List<List<Boolean>> data, Map<Integer, Integer> resets) {
        long maxCount = 0;
        int best = 1;
        for(List<Boolean> center : data) {
            Integer reloads = resets.get(data.indexOf(center));
            Long working = center.stream().filter(e -> e.equals(true)).count();
            long count = working * reloads;

            if(maxCount < count) {
                best = data.indexOf(center) + 1;
                maxCount = count;
            }
        }
        return best;
    }

    public static int getMin(List<List<Boolean>> data, Map<Integer, Integer> resets) {
        long minCount = Integer.MAX_VALUE;
        int best = 1;
        for(List<Boolean> center : data) {
            Integer reloads = resets.get(data.indexOf(center));
            Long working = center.stream().filter(e -> e.equals(true)).count();
            long count = working * reloads;

            if(minCount > count) {
                best = data.indexOf(center) + 1;
                minCount = count;
            }
        }
        return best;
    }

}

//2 3 9
//        DISABLE 1 1
//        DISABLE 2 2
//        RESET 2
//        DISABLE 2 1
//        DISABLE 2 3
//        RESET 1
//        GETMAX
//        DISABLE 2 1
//        GETMIN

//3 3 12
//        DISABLE 1 2
//        DISABLE 2 1
//        DISABLE 3 3
//        GETMAX
//        RESET 1
//        RESET 2
//        DISABLE 1 2
//        DISABLE 1 3
//        DISABLE 2 2
//        GETMAX
//        RESET 3
//        GETMIN