//22-09-30
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer [] A = new Integer[N];
        int [] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int result = 0;

        for (int i = 0; i < N; i++){
            result = result + (A[i] * B[i]);
        }
        System.out.println(result);
    }
}
