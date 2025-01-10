package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int []arr = new int[9];

        int maxIndex = 0;
        int maxValue = 0;

        for (int i =0; i < 9 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > maxValue){
                maxValue = arr[i];
                maxIndex = i + 1;
            }
        }

        bw.write(maxValue + "\n" + maxIndex);
        bw.close();

    }

}
