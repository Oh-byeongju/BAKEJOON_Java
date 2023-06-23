// 22-12-05
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4307 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());

        while (time > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int [] arr = new int[L + 1];

            for (int i = 0; i < N; i++) {
                arr[Integer.parseInt(br.readLine())] = 1;
            }

            int min_num = 0;
            int max_num = 0;
            int center = L / 2;

            for (int i = 0; i <= L; i++) {
                if (arr[i] == 1) {
                    if (i > center) {
                        min_num = Math.max(min_num, L - i);
                        max_num = Math.max(max_num, i);
                    }
                    else {
                        min_num = Math.max(i, min_num);
                        max_num = Math.max(L - i, max_num);
                    }
                }
            }
            System.out.print(min_num + " ");
            System.out.println(max_num);
            time--;
        }
    }
}
