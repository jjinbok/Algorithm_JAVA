package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[][] list = new String[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list[i][0] = st.nextToken();
            list[i][1] = st.nextToken();
            list[i][2] = String.valueOf(i);
        }

        Arrays.sort(list, (a, b) -> {
            if (a[0].equals(b[0])) {
                return Integer.parseInt(a[2]) - Integer.parseInt(a[2]);
            } else {
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            }
        });

        for (String[] a : list) {
            bw.write(a[0] + " " + a[1] + "\n");
        }
        bw.close();
    }
}