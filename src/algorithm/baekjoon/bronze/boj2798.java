package algorithm.baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cardCount = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] card = new int[cardCount];
        int twoCard;
        ArrayList<Integer> arrayList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < cardCount; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < cardCount - 1; i++) {
            for (int j = i + 1; j < cardCount; j++) {
                twoCard = card[i] + card[j];
                int temp1 = card[i];
                int temp2 = card[j];
                card[i] = 0;
                card[j] = 0;

                for (int k = 0; k < cardCount; k++) {
                    if (card[k] == 0) {
                        continue;
                    }
                    int sum = twoCard + card[k];
                    if (sum > max) {
                        continue;
                    }
                    arrayList.add(sum);
                }

                card[i] = temp1;
                card[j] = temp2;
            }
        }

        Collections.sort(arrayList);
        bw.write(arrayList.get(arrayList.size() - 1) + "");
        bw.close();

    }
}