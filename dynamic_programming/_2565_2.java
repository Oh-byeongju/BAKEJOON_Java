package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2565_2{
    public static int [] dp;
    public static int [][] arr;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N][2];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));

        for (int i = 0; i < N; i++){
            dp[i] = -1;
        }

        for(int i = 0; i < N; i++) {
            recur(i);
        }

        int max_num = 0;

        for (int i = 0; i < N; i++){
            max_num = Math.max(max_num, dp[i]);
        }
        System.out.println(N - max_num);
    }
    public static int recur(int val){

        if (dp[val] == -1){
            dp[val] = 1;

            for(int i = val-1; i >= 0; i--) {
                if(arr[val][0] > arr[i][0] && arr[val][1] > arr[i][1]) {
                    dp[val] = Math.max(dp[val], recur(i) + 1);
                }
            }
        }
        return dp[val];
    }
}