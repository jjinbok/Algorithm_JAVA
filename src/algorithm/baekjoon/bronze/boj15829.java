package algorithm.baekjoon.bronze;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        final int r = 31;
        final int M = 1234567891;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < len; i++) {
            int value = str.charAt(i) - 'a' + 1;
            hash = (hash + value * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(hash);
    }
}
