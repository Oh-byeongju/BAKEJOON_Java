//22-10-12
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971 {

    public static int N;
    public static int [][] arr;
    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        res = 2147483647;
        boolean [] check = new boolean[N];
        check[0] = true;

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(0, 0, 1, check);
        System.out.println(res);
    }

    public static void cal(int num, int pos, int depth, boolean [] check) {
        if (depth == N){
            if (arr[pos][0] == 0){
                return;
            }
            num += arr[pos][0];
            res = Math.min(res, num);
        }

        for (int i = 1; i < N; i++) {
            if (arr[pos][i] != 0 && !check[i]) {
                check[i] = true;
                num += arr[pos][i];
                cal(num, i,depth + 1, check);
                check[i] = false;
                num -= arr[pos][i];
            }
        }
    }
}

