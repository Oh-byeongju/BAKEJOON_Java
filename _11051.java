import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] arr = new int[N+1][K+1];

        for (int i = 0; i <= K; i++) {
            arr[i][i] = 1;
        }

        for(int i = 0; i <= N; i++) {
            arr[i][0] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % 10007;
            }
        }
        System.out.println(arr[N][K]);
    }
}
