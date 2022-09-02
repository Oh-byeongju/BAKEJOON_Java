import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1904_2 {
    static int [] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(cal(N));
    }

    public static int cal(int N){

        if (dp[N] == -1){
            dp[N] = (cal(N-1) + cal(N-2)) % 15746;
        }
        return dp[N];
    }
}