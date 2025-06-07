package algorithm.baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class boj10026 {

    static String[][] grid;
    static boolean[][] visited;
    static int rowAndColumn;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rowAndColumn = Integer.parseInt(br.readLine());

        grid = new String[rowAndColumn][rowAndColumn];
        visited = new boolean[rowAndColumn][rowAndColumn];

        for (int i = 0; i < rowAndColumn; i++) {
            String line = br.readLine();
            for (int j = 0; j < rowAndColumn; j++) {
                Character c = line.charAt(j);
                grid[i][j] = c.toString();
            }
        }

        int canCount = 0;
        int cantCount = 0;

        for (int i = 0; i < rowAndColumn; i++) {
            for (int j = 0; j < rowAndColumn; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    canCount++;
                }
            }
        }
        bw.write(canCount + " ");

        for (int i = 0; i < rowAndColumn; i++) {
            for (int j = 0; j < rowAndColumn; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < rowAndColumn; i++) {
            for (int j = 0; j < rowAndColumn; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cantCount++;
                }
            }
        }
        bw.write(cantCount + "");

        bw.close();
    }

    public static void bfs(int sr, int sc) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { sr, sc });
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            if (grid[r][c].equals("R")) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                        if (grid[nr][nc].equals("R") && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.offer(new int[] { nr, nc });
                        }
                    }
                }
            } else if (grid[r][c].equals("G")) {
                grid[r][c] = "R";
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                        if (grid[nr][nc].equals("G") && !visited[nr][nc]) {

                            visited[nr][nc] = true;
                            queue.offer(new int[] { nr, nc });
                        }
                    }
                }
            } else if (grid[r][c].equals("B")) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                        if (grid[nr][nc].equals("B") && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.offer(new int[] { nr, nc });
                        }
                    }
                }
            }

        }

    }
}