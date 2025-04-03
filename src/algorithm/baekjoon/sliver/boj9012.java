package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeatCount = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        Character reverseWord;

        while (repeatCount-- > 0) {
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                switch (c) {
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        reverseWord = '(';
                        if (!stack.isEmpty() && stack.peek() == reverseWord) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;

                }

            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
            stack.clear();
        }
        bw.close();
    }
}