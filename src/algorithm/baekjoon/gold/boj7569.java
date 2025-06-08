package algorithm.baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj7569 {

    static int[][][] grid;
    static int[][][] visited;

    static int row, column, level;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    static int[] dl = new int[] { 1, -1 };

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        level = Integer.parseInt(st.nextToken());

        grid = new int[row][column][level];
        visited = new int[row][column][level];

        boolean answerIsZero = true;

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < column; k++) {
                    grid[j][k][i] = Integer.parseInt(st.nextToken());
                    if (grid[j][k][i] == 1) {
                        visited[j][k][i] = 1;
                        queue.offer(new int[] { j, k, i });
                    } else if (grid[j][k][i] == 0) {
                        answerIsZero = false;
                    }
                }
            }
        }

        if (answerIsZero) {
            bw.write("0");
            bw.close();
        } else {
            int minDay = bfs();
            bw.write(minDay + "");
            bw.close();
        }

    }

    public static int bfs() {
        int count = 0;
        boolean success = true;
        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1], l = cell[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc][l] == 0 && visited[nr][nc][l] == 0) {
                        grid[nr][nc][l] = 1;
                        visited[nr][nc][l] = visited[r][c][l] + 1;
                        count = visited[nr][nc][l];
                        queue.offer(new int[] { nr, nc, l });
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                int nl = l + dl[i];

                if (nl >= 0 && nl < level) {
                    if (grid[r][c][nl] == 0 && visited[r][c][nl] == 0) {
                        grid[r][c][nl] = 1;
                        visited[r][c][nl] = visited[r][c][l] + 1;
                        count = visited[r][c][nl];
                        queue.offer(new int[] { r, c, nl });
                    }
                }
            }
        }

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    if (grid[j][k][i] == 0 && visited[j][k][i] == 0) {
                        success = false;
                    }
                }
            }
        }

        if (success) {
            return count - 1;
        }

        return -1;

    }

}