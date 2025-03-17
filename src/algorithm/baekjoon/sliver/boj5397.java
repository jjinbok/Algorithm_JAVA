package algorithm.baekjoon.sliver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

class boj5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        while (num-- > 0) {
            String line = br.readLine();
            LinkedList<Character> refineLinkedList = new LinkedList<>();
            int index = 0; // 커서 위치

            for (int j = 0; j < line.length(); j++) {
                char current = line.charAt(j);

                switch (current) {
                    case '<':
                        if (index > 0) {
                            index--;
                        }
                        break;
                    case '>':
                        if (index < refineLinkedList.size()) {
                            index++;
                        }
                        break;
                    case '-':
                        if (index > 0) {
                            refineLinkedList.remove(--index);
                        }
                        break;
                    default:
                        refineLinkedList.add(index++, current);
                        break;
                }
            }

            for (Character c : refineLinkedList) {
                bw.write(c);
            }
            bw.write("\n"); // 각 입력 후 줄바꿈
        }

        bw.close();
    }
}
