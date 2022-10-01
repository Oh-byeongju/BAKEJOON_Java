//22-09-30
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String S = br.readLine();
        char [] arr = S.toCharArray();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int b_check = 0;
                int check = 0;
                if (K <= i) {
                    check = i - K;
                }
                while (true) {
                    if (check == i) {
                        break;
                    }

                    if (arr[check] == 'H') {
                        arr[check] = 'E';
                        cnt++;
                        b_check = 1;
                        break;
                    }
                    check++;
                }

                if (b_check == 1) {
                    continue;
                }

                int check_2 = i + K + 1;
                if (N - K <= i) {
                    check_2 = N;
                }

                for (int j = i + 1; j < check_2; j++) {
                    if (arr[j] == 'H') {
                        cnt++;
                        arr[j] = 'E';
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
