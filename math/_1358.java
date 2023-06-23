package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int radius = H/2;
        int cnt = 0;

        for (int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            double input_x = Integer.parseInt(st.nextToken());
            double input_y = Integer.parseInt(st.nextToken());

            // X + W, Y + H 해줘야 좌표가 정확하게 설정됨
            if (X <= input_x && input_x <= X + W && Y <= input_y && input_y <= Y + H){
                cnt += 1;
                continue;
            }

            // 점 포함 확인 : (반지름^2) > (((원의 중심 좌표 X - 임의의 좌표 TX) ^ 2) + ((원의 중심 좌표 Y - 임의의 좌표 TY) ^ 2)))
            double temp_a = Math.pow(input_x - X, 2) + Math.pow(input_y - (Y + radius), 2);
            double temp_b = Math.pow(input_x - (X + W), 2) + Math.pow(input_y - (Y + radius), 2);

            if (Math.pow(radius, 2) >= temp_a){
                cnt += 1;
                continue;
            }

            if (Math.pow(radius, 2) >= temp_b) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
