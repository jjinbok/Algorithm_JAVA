package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class boj11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String arr1[] = new String[1001];
        String arr2[] = new String[1001];

        int countArr1[] = new int[26];
        int countArr2[] = new int[26];

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = st.nextToken();
            arr2[i] = st.nextToken();

            if (arr1[i].length() != arr2[i].length()) {
                bw.write("Impossible\n");
                continue;
            }

            for (int j = 0; j < arr1[i].length(); j++) {
                countArr1[arr1[i].charAt(j) - 'a']++;
                countArr2[arr2[i].charAt(j) - 'a']++;
            }

            if (Arrays.equals(countArr1, countArr2)) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }

            Arrays.fill(countArr1, 0);
            Arrays.fill(countArr2, 0);

        }

        bw.close();

    }
}