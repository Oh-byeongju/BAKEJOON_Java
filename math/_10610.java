// 22-11-05
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class _10610{

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        char [] arr = N.toCharArray();
        int check = 0;
        int true_false = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                true_false = 1;
            }
            check += Integer.parseInt(String.valueOf(arr[i]));
        }

        if (true_false == 0 || check % 3 != 0) {
            System.out.println(-1);
            exit(0);
        }

        Arrays.sort(arr);
        String temp = new StringBuilder(new String(arr)).reverse().toString();

        System.out.println(temp);
    }
}