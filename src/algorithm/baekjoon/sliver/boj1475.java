package algorithm.baekjoon.sliver;

import java.io.*;

class boj1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String roomNumber = br.readLine();

        int[] needNumber = new int[10];

        for (int i = 0; i < roomNumber.length(); i++) {
            needNumber[roomNumber.charAt(i) - '0']++;
        }

        int sixAndNine = (needNumber[6] + needNumber[9] + 1) / 2;

        int maxCount = 0;
        for (int i = 0; i <= 5; i++) {
            maxCount = Math.max(maxCount, needNumber[i]);
        }
        maxCount = Math.max(maxCount, needNumber[7]);
        maxCount = Math.max(maxCount, needNumber[8]);

        maxCount = Math.max(maxCount, sixAndNine);

        bw.write(maxCount + "");
        bw.close();
    }
}
