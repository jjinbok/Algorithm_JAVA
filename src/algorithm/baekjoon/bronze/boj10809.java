package algorithm.baekjoon.bronze;

import java.io.*;

class boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] alphabetIndex = new int[26];

        for (int i = 0; i < 26; i++) {
            alphabetIndex[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (alphabetIndex[idx] == -1) {
                alphabetIndex[idx] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabetIndex[i] + " ");
        }
    }
}
