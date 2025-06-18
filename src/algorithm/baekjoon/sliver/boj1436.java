package algorithm.baekjoon.sliver;

import java.io.*;

class boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 666;
        int find = 0;

        while (true) {
            if (String.valueOf(count).contains("666")) {
                find++;
            }
            if (find == N) {
                break;
            }
            count++;
        }

        bw.write(count + "");
        bw.close();
    }
}