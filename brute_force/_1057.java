// 23-01-09
package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(Z != H) {
            Z = Z/2 + Z%2;
            H = H/2 + H%2;
            cnt++;
        }

        System.out.println(cnt);
    }
}