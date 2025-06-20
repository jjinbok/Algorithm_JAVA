package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class boj5217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();

        while (N-- > 0) {
            int a = 0, b = 0;
            int A = Integer.parseInt(br.readLine());
            for (int i = 1; i < A; i++) {
                a = i;
                b = A - i;
                if (a == b || a < b) {
                    continue;
                } else {
                    arr.add(b + " " + a);
                }
            }
            Collections.sort(arr);
            bw.write("Pairs for " + A + ": ");
            for (int i = 0; i < arr.size(); i++) {
                bw.write(arr.get(i) + "");
                if (i != arr.size() - 1) {
                    bw.write(", ");
                }
            }
            bw.newLine();
            arr.clear();
        }
        bw.close();

    }
}