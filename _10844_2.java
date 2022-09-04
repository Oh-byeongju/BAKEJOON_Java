import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_2{

    public static long [][] dp;
    public static int num = 1000000000;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for (int i = 1; i <= N; i++){
            for (int j = 0; j < 10; j++){
                dp[i][j] = -1;
            }
        }

        dp[1][0] = 0;
        for (int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        long result = 0;

        for(int i = 0; i < 10; i++){
            result += recur(N,i);
        }

        System.out.println(result % num);

    }
    public static long recur(int val, int check){
        if (val == 1){
            return dp[val][check];
        }

        if (dp[val][check] == -1){
            if (check == 0){
                dp[val][check] = recur(val-1, 1);
            }
            else if (check == 9){
                dp[val][check] = recur(val-1, 8);
            }
            else{
                dp[val][check] = recur(val-1, check-1) + recur(val-1, check+1);
            }
        }
        return dp[val][check] % num;
    }
}