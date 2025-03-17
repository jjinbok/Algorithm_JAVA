package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int dp[] = new int[1001];        
        
        int n = Integer.parseInt(br.readLine());

        int []arr = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            dp[i] = 1;
            for (int j=1; j <=i; j++){
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int i=1; i<=n; i++) {
            if(dp[i] > maxValue) {
                maxValue =dp[i];
            }
        }

        bw.write(maxValue + "");
        bw.close();

    }
}