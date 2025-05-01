import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Character n = 0;

        for (int i = 0; i < N; i++) {
            n = word.charAt(i);
        }

        System.out.println(n);

    }
}