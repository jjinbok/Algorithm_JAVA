package algorithm.baekjoon.sliver;

import java.util.Scanner;

public class boj1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] arr = new int[30][30];
        int[] result = new int[T];

        for (int i = 0; i < 30; i++) {
            arr[i][i] = 1;
        }

        for (int i = 1; i < 30; i++) {
            arr[0][i] = i + 1;
        }

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            if (N == M) {
                result[i] = 1;
            } else if (N > M) {
                System.out.println("주어진 조건에 맞지 않음");
            } else {
                result[i] = arr[N - 1][M - 1];
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        scanner.close();

    }
}
/*

1 1 -> 1개 | 1 2 -> 2개 | 1 3 -> 3개 | 1 4 -> 4개
2 2 -> 1개 | 2 3 -> 3개 | 2 4 -> 6개 | 2 5 -> 10개
3 3 -> 1개 | 3 4 -> 4개 | 3 5 -> 10개 | 3 6 -> 20개

 */
