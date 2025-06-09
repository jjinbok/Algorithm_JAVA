package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj2583 {

    static int[][] grid;
    static int[][] vistied;

    static int row, column, nemoCount;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        nemoCount = Integer.parseInt(st.nextToken());

        grid = new int[row][column];
        vistied = new int[row][column];

        while (nemoCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    grid[row - 1 - i][j] = 1;
                    vistied[row - 1 - i][j] = -1;
                }
            }
        }

        int totalCount = 0;
        ArrayList<Integer> blockCountList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0 && vistied[i][j] != -1) {
                    blockCountList.add(bfs(i, j));
                    totalCount++;
                }
            }
        }

        Collections.sort(blockCountList);

        bw.write(totalCount + "\n");
        for (int i = 0; i < blockCountList.size(); i++) {
            bw.write(blockCountList.get(i) + " ");
        }
        bw.close();
    }

    public static int bfs(int sr, int sc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        int blockCount = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {

                    if (grid[nr][nc] == 0 && vistied[nr][nc] != -1) {
                        grid[r][c] = 1;
                        grid[nr][nc] = 1;
                        vistied[nr][nc] = vistied[r][c] + 1;
                        blockCount++;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        return blockCount + 1;

    }
}