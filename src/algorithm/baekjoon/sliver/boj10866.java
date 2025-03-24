package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> qDeque = new ArrayDeque<>();
        int commandCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String value;
        while (commandCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    qDeque.addFirst(st.nextToken());
                    break;
                case "push_back":
                    qDeque.addLast(st.nextToken());
                    break;
                case "pop_front":
                    value = qDeque.pollFirst();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.newLine();
                    break;
                case "pop_back":
                    value = qDeque.pollLast();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(qDeque.size() + "");
                    bw.newLine();
                    break;
                case "empty":
                    if (qDeque.isEmpty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    bw.newLine();
                    break;
                case "front":
                    value = qDeque.peekFirst();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.newLine();
                    break;
                case "back":
                    value = qDeque.peekLast();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.newLine();
                    break;
            }
        }
        bw.close();
    }
}