import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2565{

    public static int [] dp;
    public static int [][] arr;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1][2];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));

        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= i; j++){
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max_num = 0;

        for (int i = 1; i <= N; i++){
            max_num = Math.max(max_num, dp[i]);
        }
        System.out.println(N - max_num);
    }
}