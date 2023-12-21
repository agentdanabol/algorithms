package tinkoff_autumn_6;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Spirit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        List<Map<Integer, Integer>> bandList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Map<Integer, Integer> band = new ConcurrentHashMap<>(Collections.singletonMap(i, 1));
            bandList.add(band);
        }
        for (int i = 0; i < m; i++) {
            List<Integer> line = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if(line.get(0) == 1) {
                boolean isOneBand = false;
                int x = line.get(1);
                int y = line.get(2);
                Map<Integer, Integer> newBand = new HashMap<>();
                List<Map<Integer, Integer>> bandsToRemove = new ArrayList<>();
                for(Map<Integer, Integer> current : bandList) {
                    if(current.get(x) != null && current.get(y) == null) {
                        for(Map.Entry<Integer, Integer> entry : current.entrySet()) {
                            newBand.put(entry.getKey(), entry.getValue() + 1);
                        }
                        bandsToRemove.add(current);
                    }
                    else if(current.get(x) == null && current.get(y) != null) {
                        for(Map.Entry<Integer, Integer> entry : current.entrySet()) {
                            newBand.put(entry.getKey(), entry.getValue() + 1);
                        }
                        bandsToRemove.add(current);
                    }
                    else if(current.get(x) != null && current.get(y) != null) {
                        isOneBand = true;
                        break;
                    }
                }
                if(!isOneBand) {
                    bandList.removeAll(bandsToRemove);
                    bandList.add(newBand);
                }
            }
            else if(line.get(0) == 2) {
                boolean isOneBand = false;
                int x = line.get(1);
                int y = line.get(2);
                for(Map<Integer, Integer> current : bandList) {
                    if(current.get(x) != null && current.get(y) != null) {
                        System.out.println("YES");
                        isOneBand = true;
                        break;
                    }
                }
                if(!isOneBand) {
                    System.out.println("NO");
                }
            }
            else if(line.get(0) == 3) {
                int x = line.get(1);
                for(Map<Integer, Integer> current : bandList) {
                    if(current.get(x) != null) {
                        System.out.println(current.get(x));
                        break;
                    }
                }
            }
        }
    }

}
