// 22-12-09
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _16922 {
    public static int [] arr = new int[]{1, 5, 10, 50};
    public static int N;
    public static HashSet<Integer> hash;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        hash = new HashSet<>();

        dfs (0,0,0);
        System.out.println(hash.size());

    }
    public static void dfs(int at, int num, int depth) {
        if (depth >= N) {
            hash.add(num);
            return;
        }

        for (int i = at; i < 4; i++) {
            num = num + arr[i];
            dfs(i, num, depth + 1);
            num = num - arr[i];
        }
    }
}
