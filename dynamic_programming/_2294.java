// 22-09-30
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2294 {

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

        Arrays.fill(dp,10001);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                if (j - arr[i] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        if (dp[K] == 10001){
            System.out.println("-1");
        }
        else{
            System.out.println(dp[K]);
        }
    }
}
