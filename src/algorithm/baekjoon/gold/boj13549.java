package algorithm.baekjoon.gold;

import java.io.*;
import java.util.*;

class boj13549 {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] time = new int[MAX];
        Arrays.fill(time, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        time[start] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == target) {
                break;
            }

            int teleport = now * 2;
            if (teleport < MAX && time[teleport] == -1) {
                time[teleport] = time[now];
                deque.offerFirst(teleport);
            }

            int[] next = { now - 1, now + 1 };
            for (int nxt : next) {
                if (nxt >= 0 && nxt < MAX && time[nxt] == -1) {
                    time[nxt] = time[now] + 1;
                    deque.offerLast(nxt);
                }
            }
        }

        System.out.println(time[target]);
    }
}
