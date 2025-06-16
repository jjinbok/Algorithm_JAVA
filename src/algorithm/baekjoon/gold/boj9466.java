package algorithm.baekjoon.gold;

import java.io.*;
import java.util.*;

class boj9466 {

    static int[] team;
    static boolean[] visited;
    static boolean[] finished;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            team = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                team[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    dfs(i);
            }

            bw.write((n - result) + "\n");
        }

        bw.close();
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = team[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int temp = next;
            result++;
            while (temp != now) {
                temp = team[temp];
                result++;
            }
        }

        finished[now] = true;
    }
}