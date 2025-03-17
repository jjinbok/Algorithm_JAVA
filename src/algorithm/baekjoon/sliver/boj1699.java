package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class boj1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];  

        for (int i = 1; i <= n; i++) {
            dp[i] = i;  
            for (int j = 1; j * j <= i; j++) {  
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(dp[n] + "");
        bw.close();
    }
}
