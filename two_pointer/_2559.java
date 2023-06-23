package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        int [] res = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int temp = 0;

        for (int i = 0; i < K; i++){
            temp += arr[i];
        }

        res[K-1] = temp;
        int max_num = temp;

        for (int i = K; i < N; i++){
            res[i] = res[i-1] - arr[i-K] + arr[i];
            max_num = Math.max(max_num, res[i]);
        }
        System.out.println(max_num);
    }
}