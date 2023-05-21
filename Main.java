// 23-05-22 DP 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
               dp[i][j] = Integer.MAX_VALUE;
           }
       }

       // 반복문 시작
       for (int i = 0; i < N - 1; i++) {
           for (int j = 0; j < 2; j++) {

               // 현재수가 한칸 이동 가능할경우
               if (i + 1 < N) {
                   // 큰점프 사용 안한구간
                   dp[i+1][0] = Math.min(dp[i+1][0], dp[i][0] + arr[i][0]);
               }
           }
       }
   }
}