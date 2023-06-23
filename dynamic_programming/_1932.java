package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932 {

    public static int[][] arr;
    public static int[][] dp;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(check(0,0));

    }

    public static int check(int depth, int idx) {

        if(depth == N-1) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == -1) {
            dp[depth][idx] = Math.max(check(depth + 1, idx), check(depth + 1, idx + 1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }
}