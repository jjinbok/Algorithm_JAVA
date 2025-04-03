package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ironpipeAndLaser = br.readLine();

        Stack<Character> stack = new Stack<>();

        int piece = 0;
        Character reverseWord;
        Character previousWord = null;

        for (char c : ironpipeAndLaser.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    reverseWord = '(';
                    if (!stack.isEmpty() && stack.peek() == reverseWord) {
                        if (previousWord == c) {
                            stack.pop();
                            piece++;
                        } else {
                            stack.pop();
                            piece += stack.size();
                        }

                    }
                    break;
            }
            previousWord = c;
        }

        bw.write(piece + "");
        bw.close();
    }
}