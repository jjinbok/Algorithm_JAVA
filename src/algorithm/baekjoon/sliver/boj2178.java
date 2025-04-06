package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class Main {

    static int[][] grid;
    static int[][] visited;
    static int row, column;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        grid = new int[row][column];
        visited = new int[row][column];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                Character c = line.charAt(j);
                grid[i][j] = c - '0';
            }
        }

        int minRoute = bfs(0, 0);

        bw.write(minRoute + "");
        bw.close();

    }

    public static int bfs(int sr, int sc) {
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        visited[sr][sc] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            int previousCount = visited[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                        queue.add(new int[] { nr, nc });
                        visited[nr][nc] = previousCount + 1;
                    }
                }
            }

        }

        return visited[row - 1][column - 1];
    }
}