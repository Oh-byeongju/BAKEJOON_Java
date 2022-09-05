import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2156_2 {

    public static int [] dp;
    public static int [] arr;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++){
            dp[i] = -1;
        }

        dp[0] = 0; arr[0] = 0;
        dp[1] = arr[1];

        if (N >= 2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(N));
    }

    public static int recur(int val){
        if(dp[val] == -1){
            dp[val] = Math.max(Math.max(recur(val-2), recur(val-3) + arr[val-1]) + arr[val], recur(val-1));
        }
        return dp[val];
    }
}