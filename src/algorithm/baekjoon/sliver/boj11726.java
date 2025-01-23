package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1000];

        arr[0] = 1;
        arr[1] = 2;

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i < N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            System.out.println("arr[i] = " + arr[i]);
        }

        bw.write(String.valueOf(arr[N - 1]));
        bw.close();
    }
}
