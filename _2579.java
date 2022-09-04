import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2579 {

    public static int [] arr;
    public static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp,-1);

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (N >= 2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(cal(N));

    }

    public static int cal(int N){

        if (dp[N] == -1){
            dp[N] = Math.max(cal(N-2), cal(N-3) + arr[N-1]) + arr[N];
        }
        return dp[N];
    }
}
