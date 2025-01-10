package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj10810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bucketNum = Integer.parseInt(st.nextToken());
        int repeatNum = Integer.parseInt(st.nextToken());

        int[] arr = new int[bucketNum];
        for (int i = 0; i < repeatNum; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for (int j = startIndex - 1; j <= endIndex - 1; j++) {
                arr[j] = value;
            }
        }

        for (int i = 0; i < bucketNum; i++) {
            bw.write(arr[i] + " ");
        }
        bw.close();

    }

}
