package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCount = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        while (commandCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int inputValue = Integer.parseInt(st.nextToken());
                    stack.push(inputValue);
                    break;
                case "pop":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.pop() + "\n");
                    }
                    bw.flush();
                    break;
                case "top":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack.peek() + "\n");
                    }
                    bw.flush();
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    bw.flush();
                    break;
                case "empty":
                    if (stack.empty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    bw.flush();
                    break;
            }
        }
        bw.close();
    }
}