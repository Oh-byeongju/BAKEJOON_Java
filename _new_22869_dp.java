// 23-05-22 DP 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_22869_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] arr = new int[N][2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        arr[0][1] = 1;

        for (int i = 0; i < N; i++) {
            // 이전 돌에서 못건너오는 경우 continue
            if (arr[i][1] == 0) {
                continue;
            }

            for (int j = i + 1; j < N; j++) {
                // 이미 방문한 돌인경우
                if (arr[j][1] == 1) {
                    continue;
                }
                // 방문 가능할경우 방문표시
                if ((j - i) * (1 + (Math.abs(arr[i][0] - arr[j][0]))) <= K) {
                    arr[j][1] = 1;
                }
            }
        }
        System.out.println(arr[N-1][1] == 1 ? "YES" : "NO");
    }
}