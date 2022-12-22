//22-12-22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int x = 0;

        for (int i = L; i <= 100; i++) {

            if ((N - seqSum(L - 1)) / L >= 0 && (N - seqSum(L - 1)) % L == 0) {
                x = (N - seqSum(L - 1)) / L;

                for (int j = x; j < L + x; j++) {
                    System.out.print(j+" ");
                }

                System.out.println();
                exit(0);
            }
            L++;
        }
        System.out.println(-1);
    }

    public static int seqSum(int n) {
        return n * (n + 1) / 2;
    }
}