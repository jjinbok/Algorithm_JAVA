package algorithm.baekjoon.bronze;

import java.io.*;

class boj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            boolean fell = true;
            String str = br.readLine();
            if (str.equals("0"))
                break;
            Character[] charArr = new Character[str.length()];

            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                charArr[i] = c;
            }

            for (int i = 0; i < str.length(); i++) {
                if (!charArr[i].equals(charArr[(str.length() - 1) - i])) {
                    fell = false;
                    break;
                }
            }

            if (fell) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.close();

    }
}