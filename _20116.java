//22-12-28
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20116 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean check = true;
        long sum = 0;
        float cnt = 1;

        for (int i = N - 1; i > 0; i--) {
            sum += arr[i];
            double result = sum / cnt;

            if (arr[i-1] - L < result && result < arr[i-1] + L) {
                cnt++;
            }

            else {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("stable");
        }
        else {
            System.out.println("unstable");
        }
    }
}