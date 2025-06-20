package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());

        bw.write((n1 * k1) + (n2 * k2) + "");
        bw.close();
    }
}