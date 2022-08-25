import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] res = new int[10001];

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            res[temp] += 1;
        }

        for (int i = 1; i < 10001; i++) {
            while (res[i] > 0){
                sb.append(i).append('\n');
                res[i]--;
            }
        }
        System.out.println(sb);
    }
}
