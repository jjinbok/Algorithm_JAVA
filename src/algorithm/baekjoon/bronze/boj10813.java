package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj10813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int bucketNum = Integer.parseInt(st.nextToken());
        int repeatNum = Integer.parseInt(st.nextToken());

        int[] arr = new int[bucketNum];

        for (int i = 0; i < bucketNum; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < repeatNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int temp = arr[first - 1];
            arr[first - 1] = arr[second - 1];
            arr[second - 1] = temp;
        }

        for (int i = 0; i < bucketNum; i++) {
            bw.write(arr[i] + " ");
        }

        bw.close();
    }

}
