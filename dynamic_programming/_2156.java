package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156{

    public static int [] dp;
    public static int [] arr;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++){
            dp[i] = -1;
        }

        dp[0] = 0; arr[0] = 0;
        dp[1] = arr[1];

        if (N >= 2){
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < N+1; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i]);
        }

        System.out.println(dp[N]);
    }
}