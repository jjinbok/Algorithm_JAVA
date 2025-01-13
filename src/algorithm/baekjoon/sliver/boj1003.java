package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] fibonacciZero = new int[41];
        int[] fibonacciOne = new int[41];


        fibonacciZero[0] = 1;
        fibonacciZero[1] = 0;

        fibonacciOne[0] = 0;
        fibonacciOne[1] = 1;

        for (int i = 0; i < N; i++) {

            long sumZero = 0L;
            long sumOne = 0L;

            int value = Integer.parseInt(br.readLine());
            for (int j = 2; j <= value; j++) {
                fibonacciZero[j] = fibonacciZero[j - 1] + fibonacciZero[j - 2];
            }
            sumZero += fibonacciZero[value];

            for (int j = 2; j <= value; j++) {
                fibonacciOne[j] = fibonacciOne[j - 1] + fibonacciOne[j - 2];
            }
            sumOne += fibonacciOne[value];

            bw.write(sumZero + " " + sumOne + "\n");
        }


        bw.close();


    }
}
