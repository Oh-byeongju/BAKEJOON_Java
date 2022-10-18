//22-10-18
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15553 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer [] arr = new Integer[N];
        Integer [] check = new Integer[N - 1];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++){
            check[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(check);

        int result = 0;
        for (int i = 0; i < N - K; i++){
            result += check[i];
        }

        System.out.println(result + N - (N-K));
    }
}