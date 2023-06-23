// 22-12-05
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6591 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) {
                break;
            }

            K = Math.min(K, N-K);
            long result = 1;

            for (int i = 0; i < K; i++) {
                result *= (N-i);
                result /= (i+1);
            }

            System.out.println(result);
        }
    }
}
