package algorithm.baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj2146 {

    static int[][] grid;
    static int[][] visited;

    static int rowAndColumn;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

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

        int islandCount = 2;

        for (int i = 0; i < rowAndColumn; i++) {
            for (int j = 0; j < rowAndColumn; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    checkIsland(i, j, islandCount);
                    islandCount++;
                }
            }
        }

        int bridgeCount = 0;
        int min = 0;
        boolean first = true;

        while (--islandCount > 1) {

            for (int i = 0; i < rowAndColumn; i++) {
                for (int j = 0; j < rowAndColumn; j++) {
                    if (grid[i][j] == islandCount) {
                        bridgeCount = makeBridge(i, j, islandCount);

                        if (bridgeCount != -1) {
                            if (first) {
                                min = bridgeCount;
                                first = false;
                            } else {
                                if (min > bridgeCount)
                                    min = bridgeCount;
                            }
                        }

                    }
                }
            }

        }

        bw.write(min + "");
        bw.close();

    }

    public static void checkIsland(int sr, int sc, int islandCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        grid[sr][sc] = islandCount;

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rowAndColumn && nc < rowAndColumn && nc >= 0) {
                    if (grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                        grid[r][c] = islandCount;
                        grid[nr][nc] = islandCount;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    public static int makeBridge(int sr, int sc, int islandCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        int otherIsland = 0;
        boolean findOtherIsland = false;

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rowAndColumn && nc < rowAndColumn && nc >= 0) {
                    if (grid[nr][nc] != 0 && grid[nr][nc] != islandCount) {
                        otherIsland = visited[r][c];
                        findOtherIsland = true;
                        break;
                    }
                    if (grid[nr][nc] == 0 && visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[r][c] + 1;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            if (findOtherIsland) {
                for (int i = 0; i < rowAndColumn; i++) {
                    for (int j = 0; j < rowAndColumn; j++) {
                        if (grid[i][j] == 0) {
                            visited[i][j] = 0;
                        }
                    }
                }
                return otherIsland;
            }
        }

        return -1;
    }
}
