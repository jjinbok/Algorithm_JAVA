package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            str.add(st.nextToken());
        }

        bw.write(Integer.parseInt(str.get(0)) + Integer.parseInt(str.get(1)) + "\n");
        bw.write(Integer.parseInt(str.get(0)) - Integer.parseInt(str.get(1)) + "\n");
        bw.write(Integer.parseInt(str.get(0)) * Integer.parseInt(str.get(1)) + "\n");
        bw.write(Integer.parseInt(str.get(0)) / Integer.parseInt(str.get(1)) + "\n");
        bw.write(Integer.parseInt(str.get(0)) % Integer.parseInt(str.get(1)) + "\n");


        bw.close();
    }
}
