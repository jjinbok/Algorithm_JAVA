package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        int A = 0;
        for (int i = 1; i < N; i++) {
            A = i;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                Character c = str.charAt(j);
                A += c - '0';
            }
            if (N == A) {
                arrayList.add(i);
            }
        }

        Collections.sort(arrayList);

        if (arrayList.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(arrayList.get(0) + "");
        }
        bw.close();
    }
}
