package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int small = a > b ? b : a;

        int min = 0;
        for (int i = 1; i <= small; i++) {
            if (a % i == 0 && b % i == 0) {
                if (min < i)
                    min = i;
            }
        }
        bw.write(min + "\n");

        int max = 0;
        for (int i = 1; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                max = i;
                break;
            }
        }
        bw.write(max + "");
        bw.close();
    }
}