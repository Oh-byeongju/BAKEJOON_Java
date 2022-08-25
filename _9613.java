import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long sum = 0;
            int [] nums = new int[N];

            for (int j = 0; j < N; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 0; k < N-1; k++){
                for (int l = k+1; l < N; l++){
                    sum += GCD(nums[k], nums[l]);
                }
            }
            System.out.println(sum);
        }
    }
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
