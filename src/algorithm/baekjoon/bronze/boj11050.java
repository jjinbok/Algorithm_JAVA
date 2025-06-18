package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int NminusK = N - K;

        int NFac = 1;
        for (int i = 1; i <= N; i++) {
            NFac *= i;
        }

        int KFac = 1;
        for (int i = 1; i <= K; i++) {
            KFac *= i;
        }

        int NminusKFac = 1;
        for (int i = 1; i <= NminusK; i++) {
            NminusKFac *= i;
        }

        int result = NFac / (KFac * NminusKFac);
        bw.write(result + "");
        bw.close();
    }

}