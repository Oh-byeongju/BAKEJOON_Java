// 22-12-21
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class _1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean [] arr = new boolean[1004000];
        arr[1] = true;

        for (int i = 3; i < 1004000; i++) {
            if (i % 2 == 0) {
                arr[i] = true;
            }
            if (!arr[i]) {
                int start = i * 2;
                for (int j = start; j < 1004000; j = j+i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = N; i < 1004000; i++) {
            if (!arr[i]) {
                if (check(i)) {
                    System.out.println(i);
                    exit(0);
                }
            }
        }
    }

    public static boolean check(int num) {
        String temp = Integer.toString(num);
        char [] num_arr = temp.toCharArray();

        for (int i = 0; i < num_arr.length / 2; i++) {
            if (num_arr[i] != num_arr[num_arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}