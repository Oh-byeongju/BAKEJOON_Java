package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727_2 {

    public static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        if (N >= 2) {
            dp[2] = 3;
        }

        System.out.println(recur(N));
    }

    public static int recur(int val) {
        if (dp[val] == -1) {
            dp[val] = (recur(val - 1) + recur(val - 2) * 2) % 10007;
        }
        return dp[val];
    }
}