// 22-09-26
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780 {

    public static int cnt_minus = 0;
    public static int cnt_zero = 0;
    public static int cnt_plus = 0;
    public static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal(0, 0, N);
        System.out.println(cnt_minus);
        System.out.println(cnt_zero);
        System.out.println(cnt_plus);
    }

    public static void cal(int x, int y, int N){
        int number = arr[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (number != arr[i][j]) {
                    cal(x, y, N/3);
                    cal(x, y+N/3, N/3);
                    cal(x, y+(N/3*2), N/3);
                    cal(x+N/3, y, N/3);
                    cal(x+N/3, y+N/3, N/3);
                    cal(x+N/3, y+(N/3*2), N/3);
                    cal(x+(N/3*2), y, N/3);
                    cal(x+(N/3*2), y+N/3, N/3);
                    cal(x+(N/3*2), y+(N/3*2), N/3);
                    return;
                }
            }
        }
        if (number == -1){
            cnt_minus++;
        }
        else if (number == 0) {
            cnt_zero++;
        }
        else{
            cnt_plus++;
        }
    }
}
