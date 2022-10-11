//22-10-10
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21735 {

    public static int N;
    public static int M;
    public static int result;
    public static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new int[N+2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cal(1, 0, 0);
        System.out.println(result);
    }

    public static void cal(int num, int ref, int depth){
        if (depth == M || ref == N || ref == N+1){
            result = Math.max(num, result);
            return;
        }

        for (int i = 1; i <= 2; i++){
            if (i == 1) {
                num += arr[ref + i];
                cal(num, ref + i, depth + 1);
                num -= arr[ref + i];
            }

            if (i == 2){
                int temp = num;
                num = num / 2 + arr[ref + i];
                cal(num, ref + i, depth + 1);
                num = temp;
            }
        }
    }
}

