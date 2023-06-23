// 22-11-14
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20365 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        char [] arr = S.toCharArray();

        int red = 1;
        int blue = 1;

        if (arr[0] == 'B') {
            for (int i = 1; i < N; i++) {
                if (arr[i - 1] != arr[i] && arr[i] == 'R') {
                    blue++;
                }
            }
        }
        else {
            for (int i = 1; i < N; i++) {
                if (arr[i - 1] != arr[i] && arr[i] == 'B') {
                    red++;
                }
            }
        }

        System.out.println(Math.max(blue, red));
    }
}
