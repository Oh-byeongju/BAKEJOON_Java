import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] arr = new int[N+1][N+1];
        int [][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            int temp = 0;

            for (int j = y1; j <= y2; j++){
                temp += dp[x2][j] - dp[x1-1][j];

            }
            sb.append(temp + "\n");
        }
        System.out.print(sb);
    }
}

