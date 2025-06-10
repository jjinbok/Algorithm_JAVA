package algorithm.baekjoon.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj6593 {

    static Character[][][] grid;
    static int[][][] visited;

    static int row, column, floor;

    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };
    static int[] df = new int[] { 1, -1 };

    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            floor = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            column = Integer.parseInt(st.nextToken());

            if (floor == 0 && row == 0 && column == 0) {
                break;
            }

            grid = new Character[row][column][floor];
            visited = new int[row][column][floor];
            queue = new LinkedList<>();

            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < row; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < column; k++) {
                        grid[j][k][i] = line.charAt(k);
                        if (grid[j][k][i].equals('S')) {
                            visited[j][k][i] = 1;
                            queue.offer(new int[] { j, k, i });
                        }
                    }
                }
                br.readLine();
            }

            int minTime = bfs();

            if (minTime == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + minTime + " minute(s).\n");
            }
        }

        bw.close();

    }

    public static int bfs() {

        boolean end = false;
        int endValue = 0;

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1], f = cell[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    if (grid[nr][nc][f].equals('.') && visited[nr][nc][f] == 0) {
                        visited[nr][nc][f] = visited[r][c][f] + 1;
                        queue.offer(new int[] { nr, nc, f });
                    } else if (grid[nr][nc][f].equals('E') && visited[nr][nc][f] == 0) {
                        visited[nr][nc][f] = visited[r][c][f] + 1;
                        end = true;
                        endValue = visited[nr][nc][f];
                        break;
                    }
                }
            }

            if (end) {
                break;
            }

            for (int i = 0; i < 2; i++) {
                int nf = f + df[i];
                if (nf >= 0 && nf < floor) {
                    if (grid[r][c][nf].equals('.') && visited[r][c][nf] == 0) {
                        visited[r][c][nf] = visited[r][c][f] + 1;
                        queue.offer(new int[] { r, c, nf });
                    } else if (grid[r][c][nf].equals('E') && visited[r][c][nf] == 0) {
                        visited[r][c][nf] = visited[r][c][f] + 1;
                        end = true;
                        endValue = visited[r][c][nf];
                        break;
                    }
                }
            }

            if (end) {
                break;
            }

        }

        if (!end) {
            return -1;
        } else {
            return endValue - 1;
        }

    }
}