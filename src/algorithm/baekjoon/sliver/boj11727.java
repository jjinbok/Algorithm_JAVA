package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class boj11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        int n = Integer.parseInt(br.readLine());

        if (n <= 3) {
            bw.write(dp[n] + "");
            bw.close();
        } else {
            for (int i = 4; i <= n; i++){
                dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
            }
            bw.write(dp[n] + "");
            bw.close();
        }

    }
}