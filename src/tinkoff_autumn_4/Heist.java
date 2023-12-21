package tinkoff_autumn_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Heist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        List<Integer> bills = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int count = 0;
        List<Integer> rightBills = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int sum = bills.get(i);
            count ++;
            for (int j = 0; j < m; j++) {
                sum += bills.get(j);
                count ++;
                rightBills.add(bills.get(j));
            }
            rightBills.add(bills.get(i));
            if(sum == n) {
                break;
            }
            rightBills.clear();
            count = 0;
        }

        if(count == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(count);
            rightBills.forEach(e -> System.out.print(e + " "));
        }
    }

}
