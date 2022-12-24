//22-12-24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1495_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken()); // 최대값

        int [] arr = new int [N+1];
        int [] dp = new int [M+1];

        for (int i = 0; i <= M; i++) {
            dp[i] = -1;
        }
        dp[S] = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j <= M; j++) {
                if (dp[j] == i - 1) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];

                    if (0 <= plus && plus <= M)
                        list.add(plus);
                    if (0 <= minus && minus <= M)
                        list.add(minus);

                }
            }

            for (int n : list) {
                dp[n] = i;
            }
        }

        int result = -1;

        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) {
                result = Math.max(result, i);
            }
        }
        System.out.println(result);
    }
}