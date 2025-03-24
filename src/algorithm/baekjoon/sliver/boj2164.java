package algorithm.baekjoon.sliver;

import java.io.*;
import java.util.*;

class boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardNumber = Integer.parseInt(br.readLine());

        Deque<String> qDeque = new ArrayDeque<>();
        String goBackCard;
        for (int i = 1; i <= cardNumber; i++) {
            qDeque.add(String.valueOf(i));
        }

        while (qDeque.size() != 1) {
            qDeque.poll();
            goBackCard = qDeque.poll();
            qDeque.add(goBackCard);
        }

        bw.write(qDeque.poll());
        bw.close();
    }

}