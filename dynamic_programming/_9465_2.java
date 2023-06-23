// 22-10-01
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9465_2 {

    public static int [][] arr;
    public static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[2][N+1];
            dp = new int[2][N+1];

            for (int a = 0; a < 2; a++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    arr[a][j] = Integer.parseInt(st.nextToken());
                    dp[a][j] = -1;
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            System.out.println(Math.max(cal(0,N), cal(1, N)));
        }
    }

    public static int cal(int x, int y){
        if (dp[x][y] != -1){
            return dp[x][y];
        }

        int temp = (x+1)%2;
        dp[x][y] = Math.max(cal(temp, y-1), cal(temp, y-2)) + arr[x][y];

        return dp[x][y];
    }
}
