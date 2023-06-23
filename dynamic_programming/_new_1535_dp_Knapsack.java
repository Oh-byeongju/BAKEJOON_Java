// 23-05-15 DP 배낭문제
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_1535_dp_Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // DP풀때는 한칸 더 늘려서 배열선언
        int [][] dp = new int [N+1][101];
        int [] W = new int[N+1];
        int [] V = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        // 물건개수만큼 바깥쪽 최대 무게만큼 안쪽 반복문
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                // 물건을 못 넣는경우
                if (j - W[i] <= 0) {
                    dp[i][j] = dp[i-1][j];
                }
                // 물건을 넣을 수 있는경우
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][100]);
    }
}