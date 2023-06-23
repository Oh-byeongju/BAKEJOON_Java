// 22-11-12
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char [] arr = S.toCharArray();

        int zero_num = 0;
        int one_num = 0;
        int last_num = 0;

        if (arr[0] == '0') {
            zero_num = 1;
        }
        else {
            one_num = 1;
            last_num = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (last_num == 0 && arr[i] == '1') {
                one_num++;
                last_num = 1;
            }

            if (last_num == 1 && arr[i] == '0') {
                zero_num++;
                last_num = 0;
            }
        }
        System.out.println(Math.min(one_num, zero_num));
    }
}