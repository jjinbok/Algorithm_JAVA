package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

class boj30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int people = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int XL = Integer.parseInt(st.nextToken());
        int XXL = Integer.parseInt(st.nextToken());
        int XXXL = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int STcount = 0;
        int MTcount = 0;
        int LTcount = 0;
        int XLTcount = 0;
        int XXLTcount = 0;
        int XXXLTcount = 0;

        while (S != 0) {
            if (S > T) {
                S -= T;
                STcount++;
            } else {
                STcount++;
                break;
            }
        }
        while (M != 0) {

            if (M > T) {
                M -= T;
                MTcount++;
            } else {
                MTcount++;

                break;
            }

        }
        while (L != 0) {

            if (L > T) {
                L -= T;
                LTcount++;
            } else {
                LTcount++;

                break;
            }
        }
        while (XL != 0) {

            if (XL > T) {
                XL -= T;
                XLTcount++;
            } else {
                XLTcount++;

                break;
            }
        }
        while (XXL != 0) {
            if (XXL > T) {
                XXL -= T;
                XXLTcount++;
            } else {
                XXLTcount++;

                break;
            }
        }
        while (XXXL != 0) {
            if (XXXL > T) {
                XXXL -= T;
                XXXLTcount++;
            } else {
                XXXLTcount++;
                break;
            }
        }

        bw.write((STcount + MTcount + LTcount + XLTcount + XXLTcount + XXXLTcount) + "\n");

        int Pcount = 0;
        while (true) {
            if (people >= P) {
                people -= P;
                Pcount++;
            } else {
                break;
            }
        }
        bw.write(Pcount + " " + people);
        bw.close();

    }
}