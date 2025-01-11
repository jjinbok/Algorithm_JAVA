package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [][] pascal = new int [31][31];

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        pascal[0][0] = -1;
        pascal[1][1] = 1;
        pascal[2][1] = 1;
        pascal[2][2] = 1;

        if (row >= 3) {
            for (int i = 3; i <= row; i++) {
                pascal[i][1] = 1;
                pascal[i][i] = 1;
            }

            for (int i = 3; i <= row; i++) {
                for (int j = 2; j < row; j++) {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }
        bw.write(String.valueOf(pascal[row][col]));
        bw.close();


    }
}
