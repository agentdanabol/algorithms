package tinkoff_task_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxPrefixLength = 0;
        for (int i = 0; i < n; i++) {
            int currentNumber = a[i];
            frequencyMap.put(currentNumber, frequencyMap.getOrDefault(currentNumber, 0) + 1);

            boolean isBoring = true;
            int minFrequency = Integer.MAX_VALUE;
            int maxFrequency = Integer.MIN_VALUE;
            for (int frequency : frequencyMap.values()) {
                if (frequency < minFrequency) {
                    minFrequency = frequency;
                }
                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                }
                if (maxFrequency - minFrequency > 1) {
                    isBoring = false;
                    break;
                }
            }
            if (isBoring || (maxFrequency == 1 && frequencyMap.size() == i + 1) || (frequencyMap.size() == i + 1 && minFrequency == 1)) {
                maxPrefixLength = i + 1;
            }
        }

        System.out.println(maxPrefixLength);
    }

}
