import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24416 {
    public static int fibo_cnt;
    public static int [] fibo_d;
    public static int fibo_d_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fibo_cnt = 0;
        fibo_d = new int[41];
        fibo_d_cnt = 0;

        fibo(N);
        fibonacci(N);
        System.out.print(fibo_cnt+" ");
        System.out.print(fibo_d_cnt);
    }
    public static int fibo(int N) {
        if (N == 1 || N == 2){
            fibo_cnt += 1;
            return 1;
        }
        else {
            return (fibo(N - 1) + fibo(N - 2));
        }
    }
    public static int fibonacci(int N) {
        fibo_d[1] = 1;
        fibo_d[2] = 1;
        for (int i = 3; i <= N; i++){
            fibo_d_cnt += 1;
            fibo_d[i] = fibo_d[i - 1] + fibo_d[i -2];
        }
        return fibo_d[N];
    }
}