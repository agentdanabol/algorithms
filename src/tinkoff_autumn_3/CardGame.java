package tinkoff_autumn_3;

import java.util.*;
import java.util.stream.Collectors;

public class CardGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Integer> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bestSequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean isWinner = false;
        for (int i = 0; i < sequence.size(); i++) {
            for (int j = sequence.size(); j > i; j--) {
                List<Integer> temp = new ArrayList<>(sequence.subList(i, j));
                List<Integer> leftConst = new ArrayList<>(sequence.subList(0, i));
                List<Integer> rightConst = new ArrayList<>(sequence.subList(j, sequence.size()));
                Collections.sort(temp);
                List<Integer> fullSequence = new ArrayList<>();
                fullSequence.addAll(leftConst);
                fullSequence.addAll(temp);
                fullSequence.addAll(rightConst);
                if(fullSequence.equals(bestSequence)) {
                    isWinner = true;
                    break;
                }
            }
        }

        if(isWinner) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

}
