package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj2468 {

    static int[][] grid;
    static int[][] visited;

    static int rowAndColumn;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        rowAndColumn = Integer.parseInt(br.readLine());

        grid = new int[rowAndColumn][rowAndColumn];
        visited = new int[rowAndColumn][rowAndColumn];

        for (int i = 0; i < rowAndColumn; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < rowAndColumn; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int height = 1;
        int nowSafeAreaCount = 0;
        int resultSafeAreaCount = 0;

        while (height <= 100) {

            for (int i = 0; i < rowAndColumn; i++) {
                for (int j = 0; j < rowAndColumn; j++) {
                    if (grid[i][j] >= height) {
                        visited[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < rowAndColumn; i++) {
                for (int j = 0; j < rowAndColumn; j++) {
                    if (visited[i][j] == 1) {
                        queue.offer(new int[] { i, j });
                        bfs();
                        nowSafeAreaCount++;
                    }
                }
            }

            if (height == 1) {
                resultSafeAreaCount = nowSafeAreaCount;
            } else {
                if (resultSafeAreaCount < nowSafeAreaCount) {
                    resultSafeAreaCount = nowSafeAreaCount;
                }
            }
            nowSafeAreaCount = 0;

            for (int i = 0; i < rowAndColumn; i++) {
                for (int j = 0; j < rowAndColumn; j++) {
                    visited[i][j] = 0;
                }
            }

            height++;
        }

        bw.write(resultSafeAreaCount + "");
        bw.close();
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                    if (visited[nr][nc] == 1) {
                        visited[r][c] = 0;
                        visited[nr][nc] = 0;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
    }
}