package algorithm.baekjoon.sliver;

import java.util.Scanner;

public class boj9625 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int [] arrayA = new int[1000];
        int [] arrayB = new int[1000];

        arrayA[0] = 1;
        arrayB[0] = 0; // 이건 누르지 않은 상태

        arrayA[1] = 0; // 이게 1번 누른 거
        arrayB[1] = 1;

        arrayA[2] = 1;
        arrayB[2] = 1;

        for (int i = 3; i < k + 1; i++) {
            arrayA[i] = arrayA[i - 1];
            arrayB[i] = arrayB[i - 1];

            arrayA[i] -= arrayA[i - 1]; // A의 개수 n만큼 줄이고 A 0 B 1
            arrayB[i] += arrayA[i - 1]; // B의 개수 n만큼 증가 A 0 B 2
            arrayA[i] += arrayB[i - 1]; // A의 개수 A 1 B 2
        }

        System.out.print(arrayA[k] + " " + arrayB[k]);
        scanner.close();
    }
}
