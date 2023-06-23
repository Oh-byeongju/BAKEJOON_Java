// 22-10-05
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        long start = 0;
        long end = 1000000001;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (start < end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                long temp = arr[i] - mid;
                if (temp > 0){
                    cnt = cnt + temp;
                }
            }

            if (cnt < M) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
}
