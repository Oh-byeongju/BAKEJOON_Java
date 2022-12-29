//22-12-29
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12849 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        long div = 1000000007;

        long[][] arr = new long[D + 1][8];
        arr[0][0] = 1;

        for (int i = 0; i < D; i++) {
            arr[i + 1][0] = (arr[i][1] + arr[i][2]) % div;
            arr[i + 1][1] = (arr[i][0] + arr[i][2] + arr[i][3]) % div;
            arr[i + 1][2] = (arr[i][0] + arr[i][1] + arr[i][3] + arr[i][5]) % div;
            arr[i + 1][3] = (arr[i][1] + arr[i][2] + arr[i][4] + arr[i][5]) % div;
            arr[i + 1][4] = (arr[i][3] + arr[i][5] + arr[i][6]) % div;
            arr[i + 1][5] = (arr[i][2] + arr[i][3] + arr[i][4] + arr[i][7]) % div;
            arr[i + 1][6] = (arr[i][4] + arr[i][7]) % div;
            arr[i + 1][7] = (arr[i][5] + arr[i][6]) % div;
        }
        System.out.println(arr[D][0]);
    }
}