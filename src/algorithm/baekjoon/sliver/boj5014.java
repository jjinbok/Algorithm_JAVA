package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int floor = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] visited = new int[floor + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int move : new int[] { up, -down }) {
                int next = cur + move;
                if (next >= 1 && next <= floor && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        if (visited[goal] == 0) {
            bw.write("use the stairs");
        } else {
            bw.write((visited[goal] - 1) + "");
        }
        bw.close();
    }
}
