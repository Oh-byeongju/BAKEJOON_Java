//22-11-11
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _19539 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        if (total % 3 != 0) {
            System.out.println("NO");
            exit(0);
        }

        int div_num = 0;

        for (int i = 0; i < N; i++) {
            div_num += arr[i] / 2;
        }

        if (div_num >= total / 3) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}