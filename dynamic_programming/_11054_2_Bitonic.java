package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054_2_Bitonic {

    public static int[] dp;
    public static int[] dp2;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        dp2 = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = -1;
            dp2[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        for (int i = 0; i < N; i++) {
            dp[i] = dp[i] + dp2[i] -1;
        }

        int max_num = 0;

        for (int i = 0; i < N; i++) {
            max_num = Math.max(max_num, dp[i]);
        }
        System.out.println(max_num);
    }

    public static int LIS(int val) {

        if (dp[val] == -1) {
            dp[val] = 1;

            for (int i = val - 1; i >= 0; i--) {
                if (arr[i] < arr[val]) {
                    dp[val] = Math.max(dp[val], LIS(i) + 1);
                }
            }
        }
        return dp[val];
    }

    public static int LDS(int val) {

        if (dp2[val] == -1) {
            dp2[val] = 1;

            for (int i = val + 1; i < dp2.length; i++) {
                if (arr[i] < arr[val]) {
                    dp2[val] = Math.max(dp2[val], LDS(i) + 1);
                }
            }
        }
        return dp2[val];
    }
}