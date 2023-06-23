// 22-09-26
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11401 {
    public static int C = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long N_num = fac(N);
        long K_num = fac(K) * fac(N-K) % C;

        long res_num = cal(K_num, 1000000007-2) % C;
        System.out.println(N_num * res_num % C);

    }

    public static long fac(long temp) {
        long fac = 1L;

        while(temp > 1) {
            fac = (fac * temp) % C;
            temp--;
        }
        return fac;
    }

    public static long cal(long A, long num) {

        if (num == 1) {
            return A % C;
        }

        long temp = cal(A, num / 2);

        if (num % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}
