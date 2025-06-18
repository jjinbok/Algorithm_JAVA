package algorithm.baekjoon.sliver;

import java.io.*;
import java.math.BigInteger;

class boj1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        BigInteger Nfac = new BigInteger("1");

        for (long i = 1; i <= N; i++) {
            Nfac = Nfac.multiply(new BigInteger(String.valueOf(i)));
        }

        String NfacStr = String.valueOf(Nfac);
        int count = 0;
        for (int i = NfacStr.length() - 1; i > 0; i--) {
            Character c = NfacStr.charAt(i);
            if (c.equals('0')) {
                count++;
            } else {
                break;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}