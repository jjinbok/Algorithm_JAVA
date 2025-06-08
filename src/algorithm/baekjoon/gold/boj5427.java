package algorithm.baekjoon.gold;

import java.io.*;
import java.util.*;

class Main {

    static int row, column;
    static String[][] grid;
    static int[][] peopleVisited, fireVisited;

    static Queue<int[]> peopleQueue, fireQueue;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            column = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            grid = new String[row][column];
            peopleVisited = new int[row][column];
            fireVisited = new int[row][column];
            peopleQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            for (int i = 0; i < row; i++) {
                String line = br.readLine();
                for (int j = 0; j < column; j++) {
                    char c = line.charAt(j);
                    grid[i][j] = Character.toString(c);
                    peopleVisited[i][j] = -1;
                    fireVisited[i][j] = -1;

                    if (c == '@') {
                        peopleVisited[i][j] = 0;
                        peopleQueue.offer(new int[] { i, j });
                    } else if (c == '*') {
                        fireVisited[i][j] = 0;
                        fireQueue.offer(new int[] { i, j });
                    } else if (c == '#') {
                        peopleVisited[i][j] = -2;
                        fireVisited[i][j] = -2;
                    }
                }
            }

            spreadFire();
            int result = escape();

            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    static void spreadFire() {
        while (!fireQueue.isEmpty()) {
            int[] curr = fireQueue.poll();
            int r = curr[0], c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (fireVisited[nr][nc] == -1 && !grid[nr][nc].equals("#")) {
                        fireVisited[nr][nc] = fireVisited[r][c] + 1;
                        fireQueue.offer(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    static int escape() {
        while (!peopleQueue.isEmpty()) {
            int[] curr = peopleQueue.poll();
            int r = curr[0], c = curr[1];

            if (r == 0 || r == row - 1 || c == 0 || c == column - 1) {
                return peopleVisited[r][c] + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (peopleVisited[nr][nc] == -1 && !grid[nr][nc].equals("#")) {
                        if (fireVisited[nr][nc] == -1 || peopleVisited[r][c] + 1 < fireVisited[nr][nc]) {
                            peopleVisited[nr][nc] = peopleVisited[r][c] + 1;
                            peopleQueue.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
        }

        return -1;
    }
}
