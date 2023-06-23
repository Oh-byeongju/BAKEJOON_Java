// 22-10-15
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {

    public static int max_num = 0;
    public static int [] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        boolean [] check = new boolean[N];
        int [] num_arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cal(0, num_arr, check);
        System.out.println(max_num);
    }

    public static void cal(int depth, int [] num_arr, boolean [] check) {
        if (depth == N) {
            int num = 0;
            for (int i = 0; i < N-1; i++){
                num += Math.abs(num_arr[i] - num_arr[i+1]);
            }
            max_num = Math.max(max_num, num);
            return;
        }

        for (int i = 0; i < N; i++){
            if (!check[i]){
                check[i] = true;
                num_arr[depth] = arr[i];
                cal(depth + 1, num_arr, check);
                num_arr[depth] = 0;
                check[i] = false;
            }
        }
    }
}