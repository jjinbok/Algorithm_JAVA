package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] smallArr = {2, 1, 3, 2, 4};
        int[] arr = new int[N + 1];

        if (N == 1 || N == 3) {
            bw.write("-1");
            bw.close();
        } else if (N == 2) {
            bw.write("1");
            bw.close();
        } else if (4 <= N && N <= 8) {
            for (int i = 4; i <= N; i++) {
                arr[i] = smallArr[i - 4];
            }
            bw.write(String.valueOf(arr[N]));
            bw.close();
        } else if (N > 8) {

            arr[4] = 2;
            arr[5] = 1;
            arr[6] = 3;
            arr[7] = 2;
            arr[8] = 4;

            for (int i = 9; i <= N; i++) {
                arr[i] = arr[i - 5] + 1;
            }

            bw.write(String.valueOf(arr[N]));
            bw.close();
        }

    }

}

/*
    02원 <- 2원 1개         1 !

    04원 <- 2원 2개         2 $
    05원 <- 5원 1개         1 #
    06원 <- 2원 3개         3 @
    07원 <- 5원 1개 2원 1개  2 !
    08원 <- 2원 4개         4 %

    09원 <- 5원 1개 2원 2개  3 $
    10원 <- 5원 2개         2 #
    11원 <- 5원 1개 2원 3개  4 @
    12원 <- 5원 2개 2원 1개  3 !
    13원 <- 5원 1개 2원 4개  5 %

    14원 <- 5원 2개 2원 2개  4 $
    15원 <- 5원 3개         3 #
    16원 <- 5원 2개 2원 3개  5 @
    17원 <- 5원 3개 2원 1개  4 !
    18원 <- 5원 2개 2원 4개  6 %
 */
