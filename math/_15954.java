// 22-12-07
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15954 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        double result = Integer.MAX_VALUE;
        int roll = N-K;

        for (int a = 0; a <= roll; a ++) {

            for (int i = 0; i <= N-K; i++) {
                double avg = 0;

                for (int j = i; j < i+K; j++) {
                    avg += arr[j];
                }
                avg /= K;

                double res = 0;
                for (int j = i; j < i+K; j++) {
                    double temp = Math.pow((arr[j] - avg), 2);
                    res += temp;
                }
                res /= K;
                res = Math.sqrt(res);
                result = Math.min(result, res);
            }
            K = K + 1;
        }
        System.out.println(result);
    }
}
