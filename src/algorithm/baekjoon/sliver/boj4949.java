package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack;
        String line;

        while (true) {
            line = br.readLine();
            if (line.equals("."))
                break;

            stack = new Stack<>();
            boolean isValid = true;

            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty())
                isValid = false;

            if (isValid) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            bw.flush();
        }
        bw.close();
    }
}
