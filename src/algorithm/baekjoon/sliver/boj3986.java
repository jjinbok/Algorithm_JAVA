package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeatCount = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        int goodWordCount = 0;

        while (repeatCount-- > 0) {
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                goodWordCount++;
            }
            stack.clear();

        }
        bw.write(goodWordCount + "");
        bw.close();
    }
}