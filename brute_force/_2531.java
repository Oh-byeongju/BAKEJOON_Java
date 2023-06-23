// 22-12-07
package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2531 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] arr = new int[N*2];
        int result = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            arr[i+N] = temp;
        }

        for (int i = 0; i < N; i++) {
            HashSet<Integer> hash = new HashSet<>();
            for (int j = 0; j < k; j++) {
                hash.add(arr[i+j]);
            }
            hash.add(c);
            result = Math.max(result, hash.size());
        }

        System.out.println(result);
    }
}
