package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int personNumber = Integer.parseInt(st.nextToken());
        int roomLimit = Integer.parseInt(st.nextToken());

        int student[][] = new int[2][7];

        int totalNeedRoom = 0;

        while (personNumber-- > 0) {
            st = new StringTokenizer(br.readLine());

            if (Integer.parseInt(st.nextToken()) == 0) {
                student[0][Integer.parseInt(st.nextToken())]++;
            } else {
                student[1][Integer.parseInt(st.nextToken())]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (student[0][i] % roomLimit == 0) {
                totalNeedRoom += student[0][i] / roomLimit;
            } else {
                totalNeedRoom += student[0][i] / roomLimit + 1;
            }

            if (student[1][i] % roomLimit == 0) {
                totalNeedRoom += student[1][i] / roomLimit;
            } else {
                totalNeedRoom += student[1][i] / roomLimit + 1;
            }
        }

        bw.write(totalNeedRoom + "");
        bw.close();

    }
}