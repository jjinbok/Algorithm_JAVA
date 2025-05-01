package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.Stack;

class boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int repeatCount = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        while (repeatCount-- > 0) {
            int inputNumber = Integer.parseInt(br.readLine());
            if (inputNumber > start) {
                for (int i = start + 1; i <= inputNumber; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = inputNumber;
            } else if (stack.peek() != inputNumber) {
                System.out.print("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);

    }
}