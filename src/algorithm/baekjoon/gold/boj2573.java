package algorithm.baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj2573 {

    static int[][][] grid;
    static boolean[][] visited;

    static int row, column;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        grid = new int[row][column][2];
        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                int element = Integer.parseInt(st.nextToken());
                grid[i][j][0] = element;
                if (element > 0) {
                    visited[i][j] = true;
                }
            }
        }

        int cycle = 0;
        while (true) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j][0] > 0 && visited[i][j] == true) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            melting();
            if (count == 1) {
                cycle++;
            } else if (count == 0) {
                cycle = 0;
                break;
            } else {
                break;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j][0] > 0) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        bw.write(cycle + "");
        bw.close();

    }

    public static void bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            int waterCount = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc < column && nc >= 0) {
                    if (grid[nr][nc][0] == 0 && visited[nr][nc] == false) {
                        waterCount++;
                    } else if (grid[nr][nc][0] > 0 && visited[nr][nc] == true) {
                        visited[r][c] = false;
                        visited[nr][nc] = false;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            grid[r][c][1] = waterCount;
        }

    }

    public static void melting() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j][0] > 0) {
                    grid[i][j][0] -= grid[i][j][1];
                    if (grid[i][j][0] < 0)
                        grid[i][j][0] = 0;
                }
                grid[i][j][1] = 0;
            }
        }
    }
}