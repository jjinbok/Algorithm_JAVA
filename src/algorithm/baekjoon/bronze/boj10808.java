package algorithm.baekjoon.bronze;

import java.io.*;

class boj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        int count[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[(int) word.charAt(i) - 97]++;
        }

        for (int i = 0; i < count.length; i++) {
            bw.write(count[i] + " ");
        }
        bw.close();

    }
}