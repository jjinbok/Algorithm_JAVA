package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class boj7562 {

    static int grid[][];
    static int visited[][];

    static int rowAndColumn;

    static int[] dr = new int[] { -2, -1, -2, -1, 1, 2, 1, 2 };
    static int[] dc = new int[] { 1, 2, -1, -2, 2, 1, -2, -1 };

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            rowAndColumn = Integer.parseInt(br.readLine());

            grid = new int[rowAndColumn][rowAndColumn];
            visited = new int[rowAndColumn][rowAndColumn];

            st = new StringTokenizer(br.readLine());

            int startRow = Integer.parseInt(st.nextToken());
            int startColumn = Integer.parseInt(st.nextToken());
            grid[startRow][startColumn] = 1;
            visited[startRow][startColumn] = 1;
            queue.offer(new int[] { startRow, startColumn });

            st = new StringTokenizer(br.readLine());

            int endRow = Integer.parseInt(st.nextToken());
            int endColumn = Integer.parseInt(st.nextToken());
            grid[endRow][endColumn] = -1;
            visited[endRow][endColumn] = -1;

            if (startRow == endRow && startColumn == endColumn) {
                bw.write("0\n");
            } else {
                int minRoute = bfs();
                bw.write(minRoute + "\n");
            }

        }
        bw.close();

    }

    public static int bfs() {
        int count = 0;

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int r = cell[0], c = cell[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rowAndColumn && nc >= 0 && nc < rowAndColumn) {
                    if (grid[nr][nc] == 0 && visited[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        visited[nr][nc] = visited[r][c] + 1;
                        count = visited[nr][nc];
                        queue.offer(new int[] { nr, nc });
                    } else if (grid[nr][nc] == -1 && visited[nr][nc] == -1) {
                        count = visited[r][c] + 1;
                        queue.clear();
                        break;
                    }
                }
            }
        }

        return count - 1;
    }
}