package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String word1 = st.nextToken();
        String word2 = st.nextToken();

        String one = Character.toString(word1.charAt(0));
        String two = Character.toString(word1.charAt(1));
        String three = Character.toString(word1.charAt(2));

        String newWord1 = three + two + one;
        String one2 = Character.toString(word2.charAt(0));
        String two2 = Character.toString(word2.charAt(1));
        String three2 = Character.toString(word2.charAt(2));

        String newWord2 = three2 + two2 + one2;

        if (Integer.parseInt(newWord2) > Integer.parseInt(newWord1)) {
            System.out.println(newWord2);
        } else {
            System.out.println(newWord1);
        }

    }
}