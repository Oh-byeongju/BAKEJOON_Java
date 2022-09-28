//22-09-28
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N+6][N+6];
        int [] dp = new int[N+6];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N+1; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], arr[i][1] + dp[i]);
        }

        System.out.println(dp[N+1]);
    }
}
