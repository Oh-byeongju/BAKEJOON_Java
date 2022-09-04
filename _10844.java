import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844{

    public static long [][] dp;
    public static int num = 1000000000;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for (int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {

            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % num;
                }

                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % num;
                }

                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % num;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++){
            result += dp[N][i];
        }

        System.out.println(result % num);
    }
}