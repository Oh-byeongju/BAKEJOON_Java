// 22-11-08
package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _5568 {

    public static int N, K;
    public static String [] arr, res_arr;
    public static HashSet<String> hash;
    public static boolean [] visit;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new String[N];
        res_arr = new String[K];
        visit = new boolean[N];
        hash = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        dfs(0);

        System.out.println(hash.size());
    }
    public static void dfs(int depth) {
        if (depth == K) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                sb.append(res_arr[i]);
            }

            String temp = sb.toString();
            hash.add(temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                res_arr[depth] = arr[i];
                visit[i] = true;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}