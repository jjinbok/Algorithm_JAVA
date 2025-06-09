package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class boj2667 {

    static int[][] grid;
    static int[][] visited;

    static int rowAndColumn;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rowAndColumn = Integer.parseInt(br.readLine());

        grid = new int[rowAndColumn][rowAndColumn];
        visited = new int[rowAndColumn][rowAndColumn];

        int homeCount = 0;
        ArrayList<Integer> homeBlockCount = new ArrayList<>();

        for (int i = 0; i < rowAndColumn; i++) {
            String line = br.readLine();
            for (int j = 0; j < rowAndColumn; j++) {
                Character c = line.charAt(j);
                grid[i][j] = c - '0';
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < rowAndColumn; i++) {
            for (int j = 0; j < rowAndColumn; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 1) {
                    homeBlockCount.add(bfs(i, j));
                    homeCount++;
                }
            }
        }

        Collections.sort(homeBlockCount);

        bw.write(homeCount + "\n");
        for (int i = 0; i < homeBlockCount.size(); i++) {
            bw.write(homeBlockCount.get(i) + "\n");
        }
        bw.close();
    }

    public static int bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });

        int blockCount = 0;
        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                    if (grid[nr][nc] == 1 && visited[nr][nc] != 0) {
                        grid[r][c] = 0;
                        grid[nr][nc] = 0;
                        visited[nr][nc] = visited[r][c] + 1;
                        blockCount++;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }

        return blockCount + 1;
    }
}