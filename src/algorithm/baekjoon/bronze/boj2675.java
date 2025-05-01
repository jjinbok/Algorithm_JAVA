import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repaet = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < repaet; j++) {
                    sb.append(word.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}