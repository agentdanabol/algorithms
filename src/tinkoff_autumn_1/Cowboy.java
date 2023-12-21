package tinkoff_autumn_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cowboy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        scanner.nextLine();
        List<Integer> prices = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int max = 0;
        for (int i = 0; i < n; i++) {
            int current = prices.get(i);
            if(current <= s && max < current) {
                max = current;
            }
        }
        System.out.println(max);
    }

}
