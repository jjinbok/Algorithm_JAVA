package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[30];
        for (int i = 0; i < 28; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[input - 1] = input;
        }
        boolean first = true;
        for (int i = 0; i < 30; i++) {
            if (arr[i] == 0 && first) {
                bw.write((i + 1) + "\n");
                first = false;
            } else if (arr[i] == 0) {
                bw.write((i + 1) + "");
            }
        }
        bw.close();
    }

}
