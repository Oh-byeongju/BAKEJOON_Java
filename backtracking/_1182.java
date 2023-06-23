// 22-11-06
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 {

    public static int N, S, cnt;
    public static int [] arr;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        if (S == 0) {
            System.out.println(cnt - 1);
        }
        else {
            System.out.println(cnt);
        }

    }
    public static void dfs(int num, int at) {
        if (num == S) {
            cnt += 1;
        }

        for (int i = at; i < N; i++) {
            num = num + arr[i];
            dfs(num, i + 1);
            num = num - arr[i];
        }
    }
}