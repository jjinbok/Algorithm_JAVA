package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int queueSize = Integer.parseInt(st.nextToken());
        int extractNumberCount = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= queueSize; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;

        while (extractNumberCount-- > 0) {
            int extractNumber = Integer.parseInt(st.nextToken());

            int index = 0;
            for (int num : deque) {
                if (num == extractNumber)
                    break;
                index++;
            }

            if (index <= deque.size() / 2) {
                while (deque.peekFirst() != extractNumber) {
                    deque.offerLast(deque.pollFirst());
                    result++;
                }
            } else {
                while (deque.peekFirst() != extractNumber) {
                    deque.offerFirst(deque.pollLast());
                    result++;
                }
            }

            deque.pollFirst();
        }

        bw.write(result + "\n");
        bw.close();
    }
}
