// 22-11-08
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {

    public static int L, C, check_1, check_2;
    public static char [] arr, res_arr;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        res_arr = new char[L];

        dfs(0, 0);

    }
    public static void dfs(int at, int depth) {
        if (L == depth) {
            if (check_1 > 0 && check_2 > 1) {
                System.out.println(new String(res_arr));
            }
            return;
        }

        for (int i = at; i < C; i++) {
            res_arr[depth] = arr[i];
            int check_num = 0;

            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                check_1 += 1;
                check_num = 1;
            }
            else {
                check_2 += 1;
                check_num = 2;
            }

            dfs(i + 1, depth + 1);

            if (check_num == 1) {
                check_1 -= 1;
            }
            else {
                check_2 -= 1;
            }
        }
    }
}