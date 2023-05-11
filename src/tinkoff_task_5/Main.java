package tinkoff_task_5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        List<Integer> nums = Arrays.stream(line)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int count = 0;
        for(int i = 0; i < n; i++) {
            boolean state = false;
            int sum = nums.get(i);
            for(int j = i+1; j < n; j++) {
                if(state) {
                    count++;
                }
                sum += nums.get(j);
                if(sum == 0) {
                    state = true;
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

}
