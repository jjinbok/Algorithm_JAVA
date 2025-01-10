package algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class boj3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        int result;
        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            result = input % 42;
            set.add(result);
        }

        bw.write(String.valueOf(set.size()));

        bw.close();

    }

}
