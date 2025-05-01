import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String number = br.readLine();
        Character n;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            n = number.charAt(i);
            sum += Integer.parseInt(Character.toString(n));
        }
        System.out.println(sum);
    }
}