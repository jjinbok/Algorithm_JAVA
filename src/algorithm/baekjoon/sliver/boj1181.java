package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        HashSet<String> set = new HashSet<>(list);

        ArrayList<String> result = new ArrayList<>(set);
        result.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        for (String str : result) {
            bw.write(str + "\n");
        }
        bw.close();
    }
}