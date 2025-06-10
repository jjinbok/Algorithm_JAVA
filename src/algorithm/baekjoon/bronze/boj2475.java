package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int three = Integer.parseInt(st.nextToken());
        int four = Integer.parseInt(st.nextToken());
        int five = Integer.parseInt(st.nextToken());

        int oneSquare = one * one;
        int twoSquare = two * two;
        int threeSquare = three * three;
        int fourSquare = four * four;
        int fiveSquare = five * five;

        int result = (oneSquare + twoSquare + threeSquare + fourSquare + fiveSquare) % 10;

        bw.write(result + "");
        bw.close();
    }
}