package algorithm.baekjoon.bronze;

import java.io.*;

class boj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        String result = String.valueOf(num1 * num2 * num3);
        int arr[] = new int[result.length()];

        int count[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.charAt(i) - '0';
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            bw.write(count[i] + "\n");
        }

        bw.close();

    }
}