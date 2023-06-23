package dynamic_programming;

// 22-12-25
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2688_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long [][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int a = 2; a <= 64; a++) {
            for (int i = 0; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    dp[a][i] += dp[a - 1][j];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long result = 0;

            for (int i = 0; i < 10 ; i++) {
                result += dp[N][i];
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}