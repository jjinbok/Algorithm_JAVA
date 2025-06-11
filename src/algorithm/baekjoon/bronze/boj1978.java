package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class boj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean sosu = true;

        int sosuCount = 0;
        while (testCount-- > 0) {

            int N = Integer.parseInt(st.nextToken());

            if (N == 1) {
                continue;
            }

            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    sosu = false;
                    break;
                }
            }

            if (sosu) {
                sosuCount++;
            }
            sosu = true;
        }

        bw.write(sosuCount + "");
        bw.close();
    }
}