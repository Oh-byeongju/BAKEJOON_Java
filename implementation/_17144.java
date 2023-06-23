package implementation;

// 22-10-24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17144 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] dy = new int[]{-1, 0, 1, 0};
        int [] dx = new int[]{0, 1, 0, -1};

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int [][] arr = new int[R][C];

        int up_air_y = 0;
        int up_air_x = 0;
        int down_air_y = 0;
        int down_air_x = 0;

        for (int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++){
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    down_air_y = i;
                    down_air_x = j;
                }
                arr[i][j] = temp;
            }
        }
        up_air_y = down_air_y - 1;
        up_air_x = down_air_x;

        while (T > 0) {
            int [][] temp_arr = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int num = arr[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if (0 <= y && y < R && 0 <= x && x < C) {
                            if (arr[y][x] == -1) {
                                continue;
                            }
                            arr[i][j] -= num;
                            temp_arr[y][x] += num;
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++){
                for (int j = 0; j < C; j++){
                    arr[i][j] += temp_arr[i][j];
                    temp_arr[i][j] = arr[i][j];
                }
            }

            for (int i = up_air_y; i < up_air_y + 1; i++){
                for (int j = 1; j < C - 1; j++){
                    temp_arr[i][j+1] = arr[i][j];
                    temp_arr[i+1][j+1] = arr[i+1][j];
                }
            }

            for (int i = up_air_y; i > 0; i--){
                temp_arr[i-1][C-1] = arr[i][C-1];
            }

            for (int i = 0; i < 1; i++){
                for (int j = C-1; j > 0; j--){
                    temp_arr[i][j-1] = arr[i][j];
                }
            }

            for (int i = 0; i < up_air_y; i++){
                temp_arr[i+1][0] = arr[i][0];
            }

            for (int i = down_air_y; i < R - 1; i++){
                temp_arr[i+1][C-1] = arr[i][C-1];
            }

            for (int i = R - 1; i < R; i++) {
                for (int j = C-1; j > 0; j--){
                    temp_arr[i][j-1] = arr[i][j];
                }
            }

            for (int i = R - 1; i > down_air_y; i--) {
                temp_arr[i-1][0] = arr[i][0];
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = temp_arr[i][j];
                }
            }
            arr[up_air_y][up_air_x] = -1;
            arr[down_air_y][down_air_x] = -1;
            arr[up_air_y][up_air_x+1] = 0;
            arr[down_air_y][down_air_x+1] = 0;
            T--;
        }

        int result = 0;

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                result += arr[i][j];
            }
        }
        System.out.println(result+2);
    }
}
