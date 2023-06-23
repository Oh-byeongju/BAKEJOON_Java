// 22-10-21
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2513 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int [][] minus_arr = new int[N][2];
        int [][] plus_arr = new int[N][2];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > S) {
                plus_arr[i][0] = a;
                plus_arr[i][1] = b;
            }

            if (a < S) {
                minus_arr[i][0] = a;
                minus_arr[i][1] = b;
            }
        }

        Arrays.sort(plus_arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        Arrays.sort(minus_arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int result = 0;
        for (int i = 0; i < N; i++) {
            int temp = minus_arr[i][0];
            int temp2 = minus_arr[i][1];

            if (i != N -1 && temp2 < 0) {
                minus_arr[i+1][1] += temp2;
            }

            while(temp2 > 0) {
                temp2 -= K;

                if (i != N -1 && temp2 < 0) {
                    minus_arr[i+1][1] += temp2;
                }
                result += (S - temp) * 2;

            }
        }

        for (int i = 0; i < N; i++) {
            int temp3 = plus_arr[i][0];
            int temp4 = plus_arr[i][1];

            if (i != N -1 && temp4 < 0) {
                plus_arr[i+1][1] += temp4;
            }

            while(temp4 > 0) {
                temp4 -= K;

                if (i != N -1 && temp4 < 0) {
                    plus_arr[i+1][1] += temp4;
                }

                result += (temp3 - S) * 2;
            }
        }
        System.out.println(result);
    }
}