package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class boj2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> array = new ArrayList<>();

        boolean ascending = true;
        boolean descending = true;
        for (int i = 1; i <= 8; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i <= 7; i++) {
            if (!array.get(i).equals(i + 1)) {
                ascending = false;
            }
            if (!array.get(i).equals(8 - i)) {
                descending = false;
            }
        }

        if (ascending) {
            bw.write("ascending");
        } else if (descending) {
            bw.write("descending");
        } else {
            bw.write("mixed");
        }

        bw.close();

    }
}