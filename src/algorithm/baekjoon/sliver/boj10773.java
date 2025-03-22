package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCount = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while (commandCount-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        int result = 0;
        for (int stackValue : stack) {
            result += stackValue;
        }

        bw.write(result + "");
        bw.close();
    }
}