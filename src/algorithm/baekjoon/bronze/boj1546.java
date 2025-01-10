package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double[] resultArr = new double[n];
        double result = 0;
        int highScore = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > highScore) {
                highScore = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            resultArr[i] = (double) arr[i] / (double) highScore * 100;
            result += resultArr[i];
        }

        bw.write(String.valueOf(result / n));

        bw.close();

    }
}
