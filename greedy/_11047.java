package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int cnt = 0;

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i >= 0; i--){
            if (K >= arr[i]){
                cnt = cnt + K / arr[i];
                K = K % arr[i];
            }

            if (K == 0) {
                System.out.println(cnt);
                break;
            }
        }
    }
}