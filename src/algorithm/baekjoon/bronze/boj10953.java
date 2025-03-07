package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int repeatNumber = Integer.parseInt(br.readLine());

        int [] result = new int[repeatNumber];
        for (int i = 0; i < repeatNumber; i++) {

            st = new StringTokenizer(br.readLine(),",");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result[i] = a + b;
            if (i == repeatNumber - 1) {
                bw.write(String.valueOf(result[i]));
            } else {
                bw.write(result[i] + "\n");
            }
        }

        bw.close();


    }

}
