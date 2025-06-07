package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj1697 {

    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                System.out.println(visited[cur] - 1);
                return;
            }

            for (int next : new int[] { cur - 1, cur + 1, cur * 2 }) {
                if (next >= 0 && next < MAX && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}