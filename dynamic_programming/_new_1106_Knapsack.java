// 23-05-29 DP(배낭 문제)
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_1106_Knapsack {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] dp = new int[N+1][C+1];
        int [] W = new int[N+1];
        int [] V = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 특정부분 초기화
        for (int i = 1; i <= C; i++) {
            dp[0][i] = 9999999;
        }

        // 도시개수만큼 바깥쪽 최소 인원만큼 안쪽 반복문
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                // 이번 배낭문제는 무게를 넣을수 있는지가 아닌
                // 비용을 중심으로 계산
                if (j - V[i] <= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], W[i]);
                }
                // 자신의 배열에서 무언가를 더할때 내앞에 배열이 아닌
                // 자신의 배열에서 특정값을 뺀뒤 계산함(특징을 잘 봐야함)
                // dp[i][j - V[i]] + W[i]와 dp[i-1][j - V[i]] + W[i] 차이를 구분
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - V[i]] + W[i]);
                }
            }
        }
        System.out.println(dp[N][C]);
    }
}