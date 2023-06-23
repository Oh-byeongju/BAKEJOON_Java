// 22-09-25
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629 {
    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(cal(A, B));
    }
    public static long cal(long A, long num) {

        if(num == 1) {
            return A % C;
        }

        long temp = cal(A, num / 2);

        if(num % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }
}
