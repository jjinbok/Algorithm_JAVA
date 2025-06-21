package algorithm.baekjoon.sliver;

import java.io.*;

class boj1018 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = br.readLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int column = Integer.parseInt(size[1]);

        board = new char[row][column];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int result = Integer.MAX_VALUE;

        // 8x8 가능한 모든 시작점
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= column - 8; j++) {
                result = Math.min(result, getMinRepaint(i, j));
            }
        }

        bw.write(result + "\n");
        bw.close();
    }

    static int getMinRepaint(int x, int y) {
        int countW = 0;
        int countB = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W')
                        countW++;
                    if (board[i][j] != 'B')
                        countB++;
                } else {
                    if (board[i][j] != 'B')
                        countW++;
                    if (board[i][j] != 'W')
                        countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }
}
