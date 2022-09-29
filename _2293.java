//22-09-29
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N+1];
        int [] dp = new int[K+1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++){
            if (arr[i] > K){
                continue;
            }
            dp[arr[i]] += 1;
            for (int j = arr[i]+1; j <= K; j++){
                dp[j] = dp[j] + dp[j-arr[i]];
            }
        }
        System.out.println(dp[K]);
    }
}
