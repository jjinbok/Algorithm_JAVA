package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class boj4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();

            arrayList.add(a);
            arrayList.add(b);
            arrayList.add(c);

            Collections.sort(arrayList);

            a = arrayList.get(0);
            b = arrayList.get(1);
            c = arrayList.get(2);

            if ((a * a) + (b * b) == (c * c)) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }

        }

        bw.close();

    }
}