//22-10-05
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654 {

    public static long start;
    public static long end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[K];
        start = 0;
        end = 2147483647;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        end++;

        while (start < end) {
            int cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < N) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
}
