package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken());

        int gap = up - down;
        int day = (top - down) / gap;

        if ((top - down) % gap != 0) {
            day++;
        }

        System.out.println(day);
    }
}
