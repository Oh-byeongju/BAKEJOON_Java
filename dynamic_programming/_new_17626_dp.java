// 23-05-18 DP 문제
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _new_17626_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] dp = new int [50001];
        dp[1] = 1;
        int min = 0;

        for (int i = 2; i <= 50000; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int num = i - j * j;
                min = Math.min(min, dp[num]);
            }
            dp[i] = min + 1;
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}