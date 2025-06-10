package algorithm.baekjoon.bronze;

import java.io.*;

class boj31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write((a + b - c) + "\n");
        bw.write(Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c + "");
        bw.close();
    }
}