//22-09-24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {

    public static int [][] arr;
    public static int cnt_1;
    public static int cnt_0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(0,0,N);
        System.out.println(cnt_0);
        System.out.println(cnt_1);
    }

    public static void cal (int x, int y , int N){

        int number = arr[x][y];

        for (int i = x; i < x + N; i++){
            for (int j = y; j < y + N; j++){
                if (number != arr[i][j]){
                    cal(x, y,N/2);
                    cal(x, y + N/2,N/2);
                    cal(x + N/2, y,N/2);
                    cal(x + N/2, y + N/2,N/2);
                    return;
                }
            }
        }
        if (number == 1){
            cnt_1++;
        }
        else{
            cnt_0++;
        }
    }
}
