package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9461 {
    static long [] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(cal(N));
        }
    }

    public static long cal(int N){

        if (dp[N] == -1){
            dp[N] = (cal(N-2) + cal(N-3));
        }
        return dp[N];

    }
}