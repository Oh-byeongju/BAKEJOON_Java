package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865 {

    public static int [][] dp;
    public static int [] W;
    public static int [] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N+1];
        V = new int[N+1];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st1.nextToken());
            V[i] = Integer.parseInt(st1.nextToken());
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= K; j++){
                if (W[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

