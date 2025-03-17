package algorithm.baekjoon.sliver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> linkedList = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int listLenght = Integer.parseInt(st.nextToken());
        int pointSeat = Integer.parseInt(st.nextToken());

        for (int i = 0; i < listLenght; i++) {
            linkedList.add(i + 1);
        }

        int removeSeat = pointSeat;
        bw.write("<");
        while (!linkedList.isEmpty()) {
            bw.write(linkedList.remove(removeSeat - 1) + "");
            removeSeat += pointSeat - 1;

            while (!linkedList.isEmpty() && removeSeat > linkedList.size()) {
                removeSeat -= linkedList.size();
            }
            if (!linkedList.isEmpty()) {
                bw.write(", ");
            }
        }

        bw.write(">");
        bw.close();
    }
}