// 22-10-10
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(cal(0, 0, N, arr));
    }

    public static int cal(int x, int y, int num, int [][] arr) {

        if (num == 2) {
            int [] temp_arr = new int[4];
            int temp = 0;
            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    temp_arr[temp] = arr[i][j];
                    temp = temp + 1;
                }
            }
            Arrays.sort(temp_arr);
            return temp_arr[2];
        }

        int num2 = num / 2;
        int [][] arr2 = new int [num2][num2];

        for (int i = 0; i < num2; i++){
            for (int j = 0; j < num2; j++){
                arr2[i][j] = cal(i * 2, j * 2,2, arr);
            }
        }

        return cal(0, 0, num2, arr2);
    }
}

