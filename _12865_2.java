import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_2 {

    public static int [][] dp;
    public static int [] W;
    public static int [] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        dp = new int[N][K+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st1.nextToken());
            V[i] = Integer.parseInt(st1.nextToken());
        }

        System.out.println(cal(N - 1, K));
    }

    public static int cal(int x, int y) {

        if(x < 0) {
            return 0;
        }

        if(dp[x][y] == -1) {

            if(W[x] > y) {
                dp[x][y] = cal(x - 1, y);
            }

            else {
                dp[x][y] = Math.max(cal(x - 1, y), cal(x - 1, y - W[x]) + V[x]);
            }
        }
        return dp[x][y];
    }

}

