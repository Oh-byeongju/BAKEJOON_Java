package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463_2{

    public static int [] dp;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; i++){
            dp[i] = -1;
        }

        System.out.println(cal(N));
    }

    public static int cal(int N){

        if (dp[N] == -1){
            if (N%6 == 0){
                dp[N] = Math.min(cal(N-1),Math.min(cal(N/3), cal(N/2))) + 1;
            }
            else if (N%3 == 0){
                dp[N] = Math.min(cal(N/3), cal(N-1)) + 1;
            }
            else if(N%2 == 0){
                dp[N] = Math.min(cal(N/2), cal(N-1)) + 1;
            }
            else {
                dp[N] = cal(N-1) +1;
            }
        }
        return dp[N];
    }
}