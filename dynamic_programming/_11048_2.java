// 22-09-25
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11048_2 {
    public static int [][] arr;
    public static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++){
                dp[i][j] = -1;
            }
        }
        System.out.print(cal(N,M));
    }

    public static int cal(int N, int M){
        if (dp[N][M] == -1) {
            dp[N][M] = Math.max(cal(N-1, M-1) + arr[N][M],Math.max(cal(N-1, M) + arr[N][M], cal(N, M-1) + arr[N][M]));

        }
        return dp[N][M];
    }
}
