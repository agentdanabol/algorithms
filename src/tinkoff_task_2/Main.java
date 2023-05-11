package tinkoff_task_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int programs = n;
        int time = 1;

        while (programs > 0) {
            int maxChecksPerSenior;
            if(programs % m == 0) {
                maxChecksPerSenior = programs / m;
            }
            else {
                maxChecksPerSenior = programs / m + 1;
            }
            int checks = Math.min(maxChecksPerSenior * k, programs);
            time += maxChecksPerSenior;
            programs -= checks;
        }

        System.out.println(time);
    }

}
