//22-09-29
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2740 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int [][] arr1 = new int[A][B];

        for (int i = 0; i < A; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int [][] arr2 = new int[C][D];

        for (int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < D; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] arr3 = new int[A][D];
        int r = 0;

        for (int k = 0; k < B; k++) {
            for (int i = 0; i < A; i++) {
                r = arr1[i][k];
                for (int j = 0; j < D; j++) {
                    arr3[i][j] += r * arr2[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++){
            for (int j = 0; j < D; j++){
                sb.append(arr3[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
