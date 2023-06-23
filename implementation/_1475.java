// 22-10-25
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        char [] S_arr = N.toCharArray();

        int [] arr = new int[10];

        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < S_arr.length; j++){
                if (Integer.parseInt(String.valueOf(S_arr[j])) == i) {
                    arr[i] += 1;
                }
            }
        }
        arr[6] = arr[6] + arr[9];
        arr[9] = 0;

        if (arr[6] % 2 == 0) {
            arr[6] /= 2;
        }
        else{
            arr[6] = (arr[6] / 2) + 1;
        }

        int maxVal = 0;
        for (int i = 0; i <= 9; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        System.out.println(maxVal);
    }
}
