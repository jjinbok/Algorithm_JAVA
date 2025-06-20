package algorithm.baekjoon.bronze;

import java.io.*;

class boj33689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N-- > 0) {
            String name = br.readLine();
            if (name.startsWith("C"))
                count++;
        }
        bw.write(count + "");
        bw.close();
    }
}