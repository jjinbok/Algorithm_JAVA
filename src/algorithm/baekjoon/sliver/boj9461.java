package algorithm.baekjoon.sliver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class boj9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [] dp = new long[101];
        int [] count = new int[101];

        dp[1]=1;
        dp[2]=1;
        dp[3]=1;

        int repeat = Integer.parseInt(br.readLine());

        for (int i = 0; i < repeat; i++){
            count[i] = Integer.parseInt(br.readLine());

            if (count[i] < 4) {
                bw.write(String.valueOf(dp[count[i]]));
            } else {
                for (int j = 4; j <= count[i]; j++) {
                    dp[j] = dp[j - 3] + dp[j - 2];
                }
                bw.write(String.valueOf(dp[count[i]]));
            }

            if (i != repeat - 1) {
                bw.newLine();
            }
        }
        bw.close();
        }
    }
