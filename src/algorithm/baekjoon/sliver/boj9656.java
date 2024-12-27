package algorithm.baekjoon.sliver;

import java.util.Scanner;

public class boj9656 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if (N % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}