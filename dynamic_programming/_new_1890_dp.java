// 23-05-21 DP 문제
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_1890_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long [][] arr = new long[N][N];
        long [][] dp = new long[N][N];
        int row = 0;
        int col = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());

                // 0의 위치 저장
                if (arr[i][j] == 0L) {
                    col = i;
                    row = j;
                }
            }
        }
        // 첫번째 배열에서 갈수있는곳 값지정
        int num = (int) arr[0][0];
        dp[num][0] = 1L;
        dp[0][num] = 1L;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 현재 숫자가 0인경우 넘김
                if (arr[i][j] == 0L) {
                    continue;
                }

                // 현재 숫자를 행에 더할수 있는경우
                if (j + arr[i][j] < N) {
                    dp[i][(int) (j + arr[i][j])] = dp[i][(int) (j + arr[i][j])] + dp[i][j];
                }

                // 현재 숫자를 열에 더할수 있는경우
                if (i + arr[i][j] < N) {
                    dp[(int) (i + arr[i][j])][j] = dp[(int) (i + arr[i][j])][j] + dp[i][j];
                }
            }
        }
        System.out.println(dp[col][row]);
    }
}