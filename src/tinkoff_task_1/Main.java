package tinkoff_task_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int state = 0;
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)) {
                state = 1;
                break;
            }
            if(nums.get(i-1) < nums.get(i)) {
                state = 2;
                break;
            }
        }

        boolean result = true;
        if(state == 1){
            for(int i = 1; i < nums.size(); i++) {
                if(nums.get(i-1) < nums.get(i)) {
                    result = false;
                    break;
                }
            }
        }
        else if(state == 2) {
            for(int i = 1; i < nums.size(); i++) {
                if(nums.get(i-1) > nums.get(i)) {
                    result = false;
                    break;
                }
            }
        }

        if(result) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

}
