package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_2{

    public static int [] dp;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        dp = new int[11];

        for (int i = 1; i < 11; i++){
            dp[i] = -1;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++){
            int temp = Integer.parseInt(br.readLine());
            System.out.println(recur(temp));
        }
    }

    public static int recur(int val){
        if (dp[val] == -1){
            dp[val] = recur(val-3) + recur(val - 2) + recur(val - 1);
        }
        return dp[val];
    }
}