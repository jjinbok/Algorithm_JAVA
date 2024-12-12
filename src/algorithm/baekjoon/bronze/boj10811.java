package algorithm.baekjoon.bronze;

import java.util.Scanner;

public class boj10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bucketNumber = sc.nextInt();
        int reverseCount = sc.nextInt();

        int[] bucket = new int[bucketNumber];

        for (int i = 0; i < bucketNumber; i++) {
            bucket[i] = i + 1;
        }

        for (int j = 0; j < reverseCount; j++) {
            int firstBucket = sc.nextInt();
            int secondBucket = sc.nextInt();

            reverseArray(bucket, firstBucket - 1, secondBucket - 1);
        }

        for (int k = 0; k < bucketNumber; k++) {
            System.out.print(bucket[k] + " ");
        }
    }

    public static void reverseArray(int[] bucket, int first, int second) {
        while (first < second){
            int temp = bucket[first];
            bucket[first] = bucket[second];
            bucket[second] = temp;
            first++;
            second--;
        }
    }
}
