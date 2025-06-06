package algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj7576 {

    static int[][] grid;
    static int[][] visited;
    static int row, column;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        grid = new int[row][column];
        visited = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                String c = st.nextToken();
                grid[i][j] = Integer.parseInt(c);
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = 1;
                }
            }
        }

        int minDay = bfs();

        bw.write(minDay + "");
        bw.close();

    }

    public static int bfs() {
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { 1, -1, 0, 0 };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] == 0 && visited[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        visited[nr][nc] = visited[r][c] + 1;
                        queue.add(new int[] { nr, nc });
                    }
                }
            }
        }

        int findMinDay = 0;
        boolean breakPoint = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    breakPoint = true;
                    break;
                }
                if (findMinDay < visited[i][j])
                    findMinDay = visited[i][j];
            }
            if (breakPoint == true) {
                findMinDay = 0;
                break;
            }
        }

        return findMinDay - 1;
    }
}