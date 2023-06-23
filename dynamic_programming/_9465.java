// 22-10-01
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int[N+1];
            int [] arr2 = new int[N+1];
            int [] dp = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int a = 1; a <= N; a++){
                arr2[a] = Integer.parseInt(st.nextToken());
            }

            dp[1] = Math.max(arr[1], arr2[1]);

            for (int k = 2; k <= N; k++){
                arr[k] = Math.max(arr2[k-1], arr2[k-2]) + arr[k];
                arr2[k] = Math.max(arr[k-1], arr[k-2]) + arr2[k];
                dp[k] = Math.max(arr[k], arr2[k]);
            }
            System.out.println(dp[N]);
        }
    }
}
