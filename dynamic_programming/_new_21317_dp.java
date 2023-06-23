// 23-05-22 DP 문제
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_21317_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 0이 작은점프 1이 큰점프
        int [][] arr = new int[N][2];
        int [][] dp = new int[N][2];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());

        // dp 배열 초기화
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = 99999999;
            }
        }

        // 반복문 시작
        for (int i = 0; i < N - 1; i++) {
            // 현재수가 한칸 이동 가능할경우
            if (i + 1 < N) {
                // 큰점프 사용 안한구간
                dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + arr[i][0]);

                // 큰점프 사용한 구간
                dp[i+1][1] = Math.min(dp[i+1][1], dp[i][1] + arr[i][0]);
            }

            // 현재수가 두칸 이동 가능할경우
            if (i + 2 < N) {
                // 큰점프 사용 안한구간
                dp[i+2][0] = Math.min(dp[i+2][0], dp[i][0] + arr[i][1]);

                // 큰점프 사용한 구간
                dp[i+2][1] = Math.min(dp[i+2][1], dp[i][1] + arr[i][1]);
            }

            // 현재수가 세칸 이동 가능할경우
            if (i + 3 < N) {
                // 매우 큰 점프 사용
                dp[i+3][1] = Math.min(dp[i+3][1], dp[i][0] + K);
            }
        }
        System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
    }
}