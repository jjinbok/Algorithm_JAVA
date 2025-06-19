package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dungChi = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dungChi[i][0] = Integer.parseInt(st.nextToken());
            dungChi[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dungChi[i][0] < dungChi[j][0] && dungChi[i][1] < dungChi[j][1]) {
                    dungChi[i][2] += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(dungChi[i][2] + 1 + " ");
        }
        bw.close();

    }
}