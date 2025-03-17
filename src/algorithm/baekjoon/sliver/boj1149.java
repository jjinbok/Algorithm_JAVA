package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class boj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        int [][] dp = new int [1002][3];

        int houseLineNumber = Integer.parseInt(br.readLine());


        for (int i = 1; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            dp[1][0] = Integer.parseInt(st.nextToken());
            dp[1][1] = Integer.parseInt(st.nextToken());
            dp[1][2] = Integer.parseInt(st.nextToken());
        }   

        for (int i = 2; i<=houseLineNumber; i ++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(Math.min(dp[houseLineNumber][0], Math.min(dp[houseLineNumber][1], dp[houseLineNumber][2]))));
        bw.close();



    }
}
/*
 * 1. 1번 집과 2번 집은 색이 달라야 한다
 * 2. 마지막 집과 그 전의 집의 색은 달라야 한다.
 * 3. i 번째 집의 색은 앞 뒤와 색이 달라야 한다. 
 * 
 * 
 */