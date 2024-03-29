package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11722_2_LDS {

    public static int[] dp;
    public static int[] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            LDS(i);
        }

        int max_num = 0;

        for (int i = 0; i < N; i++) {
            max_num = Math.max(dp[i], max_num);
        }
        System.out.println(max_num);
    }

    public static int LDS(int val) {
        if (dp[val] == -1) {
            dp[val] = 1;

            for (int i = N - 1; i >= val; i--) {
                if (arr[val] > arr[i]) {
                    dp[val] = Math.max(dp[val], LDS(val) + 1);
                }
            }

        }
        return dp[val];
    }
}