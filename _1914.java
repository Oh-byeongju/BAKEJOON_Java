//22-12-27
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1914 {

    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        if (N < 21) {
            recur(N, 1, 3, 2);
            System.out.println(square(N) - 1);
            System.out.print(sb);
        }
        else {
            System.out.println(square2(N));
        }
    }
    public static void recur(int N, int start, int end, int sub) {
        if (N == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        recur(N-1, start, sub, end);
        sb.append(start).append(" ").append(end).append("\n");
        recur(N-1, sub, end, start);
    }

    public static int square(int N) {
        int temp = 2;
        for (int i = 0; i < N-1; i++) {
            temp = temp * 2;
        }
        return temp;
    }

    public static BigInteger square2(int N) {
        BigInteger bigNumber = new BigInteger("2");
        BigInteger bigNumber2 = new BigInteger("2");
        BigInteger bigNumber3 = new BigInteger("1");

        for (int i = 0; i < N-1; i++) {
            bigNumber = bigNumber.multiply(bigNumber2);
        }

        return bigNumber.subtract(bigNumber3);
    }
}