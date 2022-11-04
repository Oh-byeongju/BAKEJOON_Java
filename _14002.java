//22-11-04
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14002{

    public static int [][] dp;
    public static int [] arr;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= i; j++){
                if(arr[i] > arr[j]){
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][1] = j;
                    }
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
            }
        }

        int max_num = 0;
        int check_idx = 0;

        for (int i = 1; i <= N; i++){
            if (max_num < dp[i][0]) {
                check_idx = i;
            }
            max_num = Math.max(max_num, dp[i][0]);
        }
        System.out.println(max_num);

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max_num; i++) {
            stack.push(arr[check_idx]);
            check_idx = dp[check_idx][1];
        }

        for (int i = 0; i < max_num; i++) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}