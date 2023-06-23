// 23-05-16 DP 문제
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _new_1309_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] dp = new int[100001][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        // 마지막행에 따른 올수있는 앞에행 경우의수를 다 더해주면됨
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}