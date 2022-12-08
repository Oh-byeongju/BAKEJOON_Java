//22-12-08
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2607 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int [] alpha = new int[26];
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 65]++;
        }

        for (int i = 0; i < N - 1; i++) {
            int [] temp_alpha = new int[26];
            int [] result = new int[26];
            int check = 0;
            String str2 = br.readLine();

            if (Math.abs(str.length() - str2.length()) >= 2) {
                continue;
            }

            for (int j = 0; j < str2.length(); j++) {
                temp_alpha[str2.charAt(j) - 65]++;
            }

            for (int j = 0; j < 26; j++) {
                result[j] = Math.abs(alpha[j] - temp_alpha[j]);
                if (result[j] >= 2) {
                    check += 3;
                }

                if (result[j] == 1) {
                    check++;
                }
            }

            if (check <= 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
