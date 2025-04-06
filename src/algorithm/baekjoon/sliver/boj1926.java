package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj1926 {
    static int[][] grid;
    static boolean[][] visited;
    static int row, column;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        grid = new int[row][column];
        visited = new boolean[row][column];

        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    areas.add(bfs(i, j));
                }
            }
        }

        if (areas.isEmpty()) {
            bw.write("0\n0\n");
        } else {
            bw.write(areas.size() + "\n");
            bw.write(Collections.max(areas) + "\n");
        }
        bw.close();
    }

    public static int bfs(int sr, int sc) {
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        visited[sr][sc] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                        queue.add(new int[] { nr, nc });
                        visited[nr][nc] = true;
                        size++;
                    }
                }
            }
        }

        return size;
    }
}
