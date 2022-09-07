import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_2_LIS {

    public static int [] dp;
    public static int [] arr;
    public static int N;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            dp[i] = -1;
        }

        for(int i = 0; i < N; i++) {
            recur(i);
        }

        int max_num = dp[0];

        for (int i = 0; i < N; i++){
            max_num = Math.max(max_num,dp[i]);
        }
        System.out.println(max_num);
    }
    public static int recur(int val){

        if (dp[val] == -1){
            dp[val] = 1;

            for(int i = val-1; i >= 0; i--) {
                if(arr[i] < arr[val]) {
                    dp[val] = Math.max(dp[val], recur(i) + 1);
                }
            }
        }
        return dp[val];
    }
}