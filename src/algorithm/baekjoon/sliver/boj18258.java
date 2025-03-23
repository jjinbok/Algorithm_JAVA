package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCount = Integer.parseInt(br.readLine());

        Deque<String> queue = new ArrayDeque<>();
        StringTokenizer st;
        String value;
        while (commandCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.add(st.nextToken());
                    break;
                case "pop":
                    value = queue.poll();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(queue.size() + "");
                    bw.write("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    bw.write("\n");
                    break;
                case "front":
                    value = queue.peek();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.write("\n");
                    break;
                case "back":
                    value = queue.peekLast();
                    if (value == null) {
                        bw.write("-1");
                    } else {
                        bw.write(value);
                    }
                    bw.write("\n");
                    break;
            }
        }
        bw.close();

    }
}