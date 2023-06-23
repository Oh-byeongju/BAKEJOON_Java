// 22-10-02
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11444 {

    public static long mod_num = 1000000007;
    public static long [][] arr;
    public static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        arr = new long[][]{{1, 1}, {1, 0}};
        long[][] A = {{1, 1} , {1, 0}};

        System.out.println(cal(A,N)[1][0]);
    }

    public static long [][] cal(long [][] array, long num){
        if (num == 1 || num == 0){
            return array;
        }

        long [][] ret = cal(array, num/2);

        ret = multi(ret, ret);

        if(num % 2 == 1L) {
            ret = multi(ret, arr);
        }
        return ret;
    }

    public static long [][] multi(long[][] a, long[][] b) {

        long [][] temp_arr = new long[2][2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    temp_arr[i][j] += a[i][k] * b[k][j];
                    temp_arr[i][j] %= mod_num;
                }
            }
        }
        return temp_arr;
    }
}
