import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String word = br.readLine();
            Character startWord = word.charAt(0);
            Character endWord = word.charAt(word.length() - 1);

            sb.append(startWord).append(endWord).append("\n");
        }
        System.out.println(sb);
    }
}