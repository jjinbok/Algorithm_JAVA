package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [][] pascal = new int [31][31];

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int vert = Integer.parseInt(st.nextToken());

        int smallPascalValue = 0;

        pascal[0][0] = -1;
        pascal[1][1] = 1;
        pascal[2][1] = 1;
        pascal[2][2] = 1;

        for (int i = 3; i <= row + vert; i++) {
            pascal[i][1] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 3; i <= row + vert; i++) {
            for (int j = 2; j < row + vert; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        int nextRow = 0;

        for (int i = row; i <= row + vert - 1; i++) {
            for (int j = col; j <= col + nextRow; j++) {
                smallPascalValue += pascal[i][j];
            }
            nextRow++;
        }

        bw.write(String.valueOf(smallPascalValue));
        bw.close();
    }

}
