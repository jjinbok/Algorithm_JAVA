package algorithm.baekjoon.bronze;

import java.io.*;

class boj28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();

        int result = 0;

        if (!one.equals("Fizz") && !one.equals("Buzz") && !one.equals("FizzBuzz")) {
            int oneInt = Integer.parseInt(one);
            result = oneInt + 3;
            if (result % 3 == 0 && result % 5 == 0) {
                bw.write("FizzBuzz");
            } else if (result % 3 == 0 && result % 5 != 0) {
                bw.write("Fizz");
            } else if (result % 3 != 0 && result % 5 == 0) {
                bw.write("Buzz");
            } else {
                bw.write(result + "");
            }
        } else if (!two.equals("Fizz") && !two.equals("Buzz") && !two.equals("FizzBuzz")) {
            int twoInt = Integer.parseInt(two);
            result = twoInt + 2;
            if (result % 3 == 0 && result % 5 == 0) {
                bw.write("FizzBuzz");
            } else if (result % 3 == 0 && result % 5 != 0) {
                bw.write("Fizz");
            } else if (result % 3 != 0 && result % 5 == 0) {
                bw.write("Buzz");
            } else {
                bw.write(result + "");
            }
        } else {
            int threeInt = Integer.parseInt(three);
            result = threeInt + 1;
            if (result % 3 == 0 && result % 5 == 0) {
                bw.write("FizzBuzz");
            } else if (result % 3 == 0 && result % 5 != 0) {
                bw.write("Fizz");
            } else if (result % 3 != 0 && result % 5 == 0) {
                bw.write("Buzz");
            } else {
                bw.write(result + "");
            }
        }

        bw.close();

    }
}