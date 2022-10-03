//22-10-02
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830 {

    public static int [][] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int [][] result = cal(arr, B);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int [][] cal(int[][] A, long num) {

        if(num == 1L) {
            return A;
        }

        int [][] ret = cal(A, num / 2);

        ret = multi(ret, ret);

        if(num % 2 == 1L) {
            ret = multi(ret, arr);
        }

        return ret;
    }

    public static int [][] multi(int[][] a, int[][] b) {

        int [][] temp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }
}
