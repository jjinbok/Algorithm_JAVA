package algorithm.baekjoon.bronze;

import java.io.*;

class boj10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean palindrome = true;

        String word = br.readLine();
        Character[] right = new Character[word.length()];

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            right[i] = c;
        }

        for (int i = 0; i < (word.length() / 2); i++) {
            if (!right[i].equals(right[(word.length() - 1) - i])) {
                palindrome = false;
            }
        }

        if (palindrome) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.close();
    }
}