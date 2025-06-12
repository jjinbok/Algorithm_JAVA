import java.io.*;
import java.util.*;

class Main {
    static int[][] grid;
    static int[][][] visited;

    static int row, column;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        grid = new int[row][column];
        visited = new int[row][column][2];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        bw.write(result + "\n");
        bw.close();
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 0 });
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0], c = now[1], isBroken = now[2];

            if (r == row - 1 && c == column - 1) {
                return visited[r][c][isBroken];
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < column) {
                    // 벽이 아닌 경우
                    if (grid[nr][nc] == 0 && visited[nr][nc][isBroken] == 0) {
                        visited[nr][nc][isBroken] = visited[r][c][isBroken] + 1;
                        queue.offer(new int[] { nr, nc, isBroken });
                    }
                    // 벽이고 아직 안 부쉈다면
                    else if (grid[nr][nc] == 1 && isBroken == 0 && visited[nr][nc][1] == 0) {
                        visited[nr][nc][1] = visited[r][c][isBroken] + 1;
                        queue.offer(new int[] { nr, nc, 1 });
                    }
                }
            }
        }

        return -1;
    }
}
