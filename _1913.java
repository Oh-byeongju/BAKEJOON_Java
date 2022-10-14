//22-10-14
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int check = Integer.parseInt(br.readLine());

        int [][] arr = new int[N][N];
        int y = 0;
        int x = 0;
        int num = 1;
        int x_pos = 0;
        int y_pos = 0;

        if (N % 2 == 0){
            y = N / 2;
            x = N / 2 - 1;
            y_pos = y + 1;
            x_pos = x + 1;
            arr[y][x] = 1;
        }
        else {
            y = N / 2;
            x = N / 2;
            y_pos = y + 1;
            x_pos = x + 1;
            arr[y][x] = 1;
        }

        for (int i = 2; i <= N; i++){
            if (i % 2 == 0) {
                arr[--y][x] = ++num;
                if (num == check) {
                    y_pos = y+1;
                    x_pos = x+1;
                }

                for (int j = 1; j < i; j++) {
                    arr[y][++x] = ++num;
                    if (num == check) {
                        y_pos = y+1;
                        x_pos = x+1;
                    }
                }

                for (int j = 1; j < i; j++) {
                    arr[++y][x] = ++num;
                    if (num == check) {
                        y_pos = y+1;
                        x_pos = x+1;
                    }
                }
            }
            else {
                arr[++y][x] = ++num;
                if (num == check) {
                    y_pos = y+1;
                    x_pos = x+1;
                }

                for (int j = 1; j < i; j++){
                    arr[y][--x] = ++num;
                    if (num == check) {
                        y_pos = y+1;
                        x_pos = x+1;
                    }
                }

                for (int j = 1; j < i; j++){
                    arr[--y][x] = ++num;
                    if (num == check) {
                        y_pos = y+1;
                        x_pos = x+1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(y_pos+" "+x_pos);
    }
}