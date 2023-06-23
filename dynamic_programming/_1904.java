package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1904 {
    static long [] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);

    }
}