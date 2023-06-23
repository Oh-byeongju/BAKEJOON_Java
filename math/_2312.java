// 22-12-22
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean [] arr = new boolean[100000];
        arr[1] = true;

        for (int i = 3; i < 100000; i++) {
            if (i % 2 == 0) {
                arr[i] = true;
            }
            if (!arr[i]) {
                int start = i * 2;
                for (int j = start; j < 100000; j = j+i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int [] check = new int[100000];

            while (N > 1) {
                for (int j = 2; j < 100000; j++) {
                    if (!arr[j]) {
                        if (N % j == 0) {
                            N = N / j;
                            check[j]++;
                            break;
                        }
                    }
                }
            }
            for (int j = 2; j < 100000; j++) {
                if (check[j] > 0) {
                    System.out.print(j+" ");
                    System.out.println(check[j]);
                }
            }
        }
    }
}