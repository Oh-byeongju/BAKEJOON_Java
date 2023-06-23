// 22-11-16
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17271 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[10001];

        for (int i = 1; i < M; i++) {
            arr[i] = 1;
        }
        arr[M] = 2;

        for (int i = M+1; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - M]) % 1000000007;
        }

        System.out.println(arr[N]);
    }
}