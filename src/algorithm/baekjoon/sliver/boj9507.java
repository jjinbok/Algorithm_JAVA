package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj9507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[68];
        long[] resultArr = new long[N];
        int resultInt;

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < 68; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4];
        }

        for (int i = 0; i < N; i++) {
            resultInt = Integer.parseInt(br.readLine());
            resultArr[i] = arr[resultInt];
            bw.write(resultArr[i] + "\n");
        }

        bw.close();


    }

}
