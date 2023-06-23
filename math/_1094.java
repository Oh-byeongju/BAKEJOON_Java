// 22-10-26
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1094 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        int stick = 64;

        while (X > 0) {
            if (stick > X) {
                stick = stick / 2;
            }
            else {
                cnt++;
                X = X - stick;
            }
        }
        System.out.println(cnt);
    }
}
