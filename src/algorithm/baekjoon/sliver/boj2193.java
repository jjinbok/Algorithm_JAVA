package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class boj2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        int number = Integer.parseInt(br.readLine());
        if (number < 3){
            bw.write(String.valueOf(dp[number]));
            bw.close();
            return;
        }
        for (int i=3;i<=number;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        bw.write(String.valueOf(dp[number]));
        bw.close();
    }
}