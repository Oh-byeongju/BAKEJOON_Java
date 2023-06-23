// 22-11-05
package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int minus_num = B.length() - A.length();
        char [] A_arr = A.toCharArray();
        char [] B_arr = B.toCharArray();
        int result_num = 0;

        for (int i = 0; i <= minus_num; i++) {
            int temp = 0;
            for (int j = 0; j < A.length(); j++) {
                if (B_arr[j + i] == A_arr[j]) {
                    temp++;
                }
            }
            result_num = Math.max(temp, result_num);
        }
        System.out.println(A.length() - result_num);
    }
}