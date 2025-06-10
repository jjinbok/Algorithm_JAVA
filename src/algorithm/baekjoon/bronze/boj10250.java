package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int visitorNumber = Integer.parseInt(st.nextToken());

            String[][] building = new String[row][column];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    building[i][j] = String.valueOf(i + 1) + String.valueOf(j);
                }
            }
            int count = 1;

            while (visitorNumber > row) {
                visitorNumber -= row;
                count++;
            }

            String X = String.valueOf(visitorNumber);

            String Y;

            if (count < 10) {
                Y = "0" + String.valueOf(count);
            } else {
                Y = String.valueOf(count);
            }

            bw.write(X + Y + "\n");
        }
        bw.close();
    }
}