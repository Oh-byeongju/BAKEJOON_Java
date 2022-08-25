import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashSet<String> hash = new HashSet<String>();

        for (int i = 1; i < S.length() + 1; i++) {
            int cnt = 0;
            for (int j = i; j < S.length() + 1; j++) {
                hash.add(S.substring(cnt, j));
                cnt++;
            }
        }
        System.out.println(hash.size());
    }
}
