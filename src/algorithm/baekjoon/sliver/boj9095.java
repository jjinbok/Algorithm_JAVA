package algorithm.baekjoon.sliver;

import java.util.Scanner;

public class boj9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] howToMakeNumber = new int[10];
        int[] questionNumber = new int[10];

        howToMakeNumber[0] = 1;
        howToMakeNumber[1] = 2;
        howToMakeNumber[2] = 4;

        for (int i = 3; i < howToMakeNumber.length; i++) {
            howToMakeNumber[i] = howToMakeNumber[i - 3] + howToMakeNumber[i - 2] + howToMakeNumber[i - 1];
        }

        for (int i = 0; i < N; i++) {
            questionNumber[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(howToMakeNumber[questionNumber[i] - 1]);
        }
        scanner.close();
    }
}
