package algorithm.baekjoon.gold;

import java.io.*;
import java.util.*;

class boj4179 {

    static int row, column;
    static char[][] grid;
    static int[][] fireVisited;
    static int[][] joeVisited;

    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> joeQueue = new LinkedList<>();

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        grid = new char[row][column];
        fireVisited = new int[row][column];
        joeVisited = new int[row][column];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'F') {
                    fireQueue.offer(new int[] { i, j });
                    fireVisited[i][j] = 1;
                } else if (grid[i][j] == 'J') {
                    joeQueue.offer(new int[] { i, j });
                    joeVisited[i][j] = 1;
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int bfs() {
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] != '#' && fireVisited[nr][nc] == 0) {
                        fireVisited[nr][nc] = fireVisited[cur[0]][cur[1]] + 1;
                        fireQueue.offer(new int[] { nr, nc });
                    }
                }
            }
        }

        while (!joeQueue.isEmpty()) {
            int[] cur = joeQueue.poll();
            int r = cur[0], c = cur[1];

            if (r == 0 || r == row - 1 || c == 0 || c == column - 1) {
                return joeVisited[r][c];
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] == '.' && joeVisited[nr][nc] == 0) {
                        if (fireVisited[nr][nc] == 0 || fireVisited[nr][nc] > joeVisited[r][c] + 1) {
                            joeVisited[nr][nc] = joeVisited[r][c] + 1;
                            joeQueue.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
        }

        return -1;
    }
}
