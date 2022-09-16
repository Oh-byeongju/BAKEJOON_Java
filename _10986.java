import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;
        long [] arr = new long[N+1];
        long [] check = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = (arr[i-1] + Integer.parseInt(st.nextToken())) % M;
            if (arr[i] == 0){
                result++;
            }
            check[(int) arr[i]]++;
        }

        for (int i = 0; i < M; i++){
            if(check[i] > 1) {
                result += (check[i] * (check[i]-1) / 2);
            }
        }
        System.out.println(result);
    }
}

