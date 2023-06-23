package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {

    public static int N;
    public static boolean [] check;
    public static int [][] arr;
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0,0);
        System.out.println(result);

    }

    public static void combi(int idx, int depth){

        if(depth == N / 2) {
            cal();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                combi(i + 1, depth + 1);
                check[i] = false;
            }
        }
    }

    public static void cal(){

        int start = 0;
        int link = 0;

        for (int i = 0; i < N -1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }

                else if (!check[i] && !check[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int temp = Math.abs(start - link);

        result = Math.min(temp, result);
    }
}