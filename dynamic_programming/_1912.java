package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912 {
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max_num = dp[0];

        for (int i = 1; i < N; i++){
            if (dp[i] + dp[i-1] > dp[i]){
                dp[i] = dp[i] + dp[i-1];
                max_num = Math.max(max_num, dp[i]);
            }
            max_num = Math.max(max_num, dp[i]);
        }
        System.out.println(max_num);
    }
}
