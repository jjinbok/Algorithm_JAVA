package algorithm.baekjoon.sliver;

import java.io.*;

public class boj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 계단 개수
        int[] stairs = new int[n + 1]; // 계단 점수
        int[] dp = new int[n + 1]; // DP 테이블

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write(String.valueOf(stairs[1]));
            bw.close();
            return;
        }

        // 초기값 설정
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        if (n >= 3) {  // n이 3 이상일 때만 실행되도록 조건 추가
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
