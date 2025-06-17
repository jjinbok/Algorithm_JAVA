package algorithm.baekjoon.bronze;

import java.io.*;

class boj14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ISBN = br.readLine();

        int sum = 0;
        int weightOfStar = 0;

        for (int i = 0; i < 12; i++) {
            char c = ISBN.charAt(i);
            int weight = (i % 2 == 0) ? 1 : 3;

            if (c == '*') {
                weightOfStar = weight;
            } else {
                int num = c - '0';
                sum += num * weight;
            }
        }

        int checkDigit = ISBN.charAt(12) - '0';

        for (int d = 0; d <= 9; d++) {
            int total = sum + d * weightOfStar + checkDigit;
            if (total % 10 == 0) {
                bw.write(d + "\n");
                break;
            }
        }

        bw.close();
    }
}
