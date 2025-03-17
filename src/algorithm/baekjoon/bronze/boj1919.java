package algorithm.baekjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class boj1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        String word1 = br.readLine();
        String word2 = br.readLine();

        // 알파벳 26개에 대한 카운트를 위한 배열
        int[] count1 = new int[26];  // 첫 번째 단어의 알파벳 개수
        int[] count2 = new int[26];  // 두 번째 단어의 알파벳 개수

        // 첫 번째 단어에서 각 문자의 개수 세기
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }

        // 두 번째 단어에서 각 문자의 개수 세기
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        // 문자를 제거해야 할 최소 개수를 구하기
        int removeCount = 0;
        for (int i = 0; i < 26; i++) {
            removeCount += Math.abs(count1[i] - count2[i]);
        }

        // 결과 출력
        System.out.println(removeCount);
    }
}
