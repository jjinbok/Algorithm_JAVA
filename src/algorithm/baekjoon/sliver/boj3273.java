package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        // 배열 생성
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(arr);

        int startPoint = 0;
        int endPoint = n - 1;
        int count = 0;
        int temp = 0;

        // start point와 end point가 만날 때까지 반복
        while (startPoint < endPoint) {
            temp = arr[startPoint] + arr[endPoint];
            // start point + end point > x ?
            if (temp > x) {
                // end point 왼쪽으로 한 칸 이동
                endPoint--;
            }
            // start point + end point < x ?
            else if (temp < x) {
                // start point 오른쪽으로 한 칸 이동
                startPoint++;
            }
            // start point + end point == x ?
            else {
                // start point 오른쪽으로, end point 왼쪽으로 한 칸씩 이동
                startPoint++;
                endPoint--;
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}