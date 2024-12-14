package algorithm.baekjoon.bronze;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class boj2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputPeople = sc.nextInt();

        int[] resultPeople = new int[inputPeople];

        while (inputPeople > 0) {
            int floor = sc.nextInt();
            int room = sc.nextInt();

            int[][] people = new int[floor + 1][room + 1];

            for (int i = 1; i <= room; i++) {
                people[0][i] = i;
            }

            for (int f = 1; f <= floor; f++) {
                for (int r = 1; r <= room; r++) {
                    people[f][r] = people[f][r - 1] + people[f - 1][r];
                }
            }

            resultPeople[inputPeople - 1] = people[floor][room];
            inputPeople--;
        }

        int lengthValue = resultPeople.length;

        for (int i = lengthValue; i > 0; i--) {
            System.out.println(resultPeople[i - 1]);
        }
    }
}