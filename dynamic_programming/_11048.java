// 22-09-25
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11048 {
    public static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                arr[i][j] = Math.max(arr[i-1][j-1] + arr[i][j],Math.max(arr[i-1][j] + arr[i][j], arr[i][j-1] + arr[i][j]));
            }
        }
        System.out.print(arr[N][M]);
    }
}
