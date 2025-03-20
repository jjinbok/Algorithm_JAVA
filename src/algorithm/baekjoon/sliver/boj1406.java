package algorithm.baekjoon.sliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> linkedList = new LinkedList<>();

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            linkedList.add(word.charAt(i));
        }

        ListIterator<Character> iterator = linkedList.listIterator(linkedList.size());

        int orderCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < orderCount; i++) {
            StringTokenizer order = new StringTokenizer(br.readLine());
            switch (order.nextToken()) {
                case "P":
                    iterator.add(order.nextToken().charAt(0));
                    break;
                case "L":
                    if (iterator.hasPrevious())
                        iterator.previous();
                    break;
                case "D":
                    if (iterator.hasNext())
                        iterator.next();
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
            }
        }

        for (Character value : linkedList) {
            bw.write(value + "");
        }
        bw.close();
    }
}
