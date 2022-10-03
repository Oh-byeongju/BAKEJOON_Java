//22-10-02
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());
        int check = 0;

        while (true) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.delete(T.length() - 1, T.length());
            }
            else {
                T.delete(T.length() - 1, T.length());
                T.reverse();
            }

            if (T.length() == S.length()) {
                if (T.toString().equals(S.toString())){
                    check = 1;
                }
                break;
            }
        }

        System.out.println(check);
    }
}
