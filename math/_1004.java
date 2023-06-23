package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                int CX = Integer.parseInt(st.nextToken());
                int CY = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                if (Math.pow(X1 - CX, 2) + Math.pow(Y1 - CY, 2) < Math.pow(R, 2) &&
                        Math.pow(X2 - CX, 2) + Math.pow(Y2 - CY, 2) < Math.pow(R, 2)){
                    continue;
                }
                else if (Math.pow(X1 - CX, 2) + Math.pow(Y1 - CY, 2) < Math.pow(R, 2) ||
                        Math.pow(X2 - CX, 2) + Math.pow(Y2 - CY, 2) < Math.pow(R, 2)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
