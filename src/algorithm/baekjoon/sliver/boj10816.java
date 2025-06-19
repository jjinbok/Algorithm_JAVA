package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.StringTokenizer;

class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int plusArr[] = new int[10000001];
        int minusArr[] = new int[10000001];
        int zero = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int V = Integer.parseInt(st.nextToken());
            if (V > 0) {
                plusArr[V] += 1;
            } else if (V == 0) {
                zero++;
            } else {
                minusArr[-V] += 1;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int V = Integer.parseInt(st.nextToken());
            if (V > 0) {
                bw.write(plusArr[V] + " ");
            } else if (V == 0) {
                bw.write(zero + " ");
            } else {
                bw.write(minusArr[-V] + " ");
            }
        }
        bw.close();
    }
}