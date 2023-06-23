// 22-11-14
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _25391 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long result = 0;

        int [][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 특별상 우대
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) {
                    return o2[0] - o1[0];
                }
                else {
                    return o2[1] - o1[1];
                }
            }
        });

        for (int i = 0; i < K; i++) {
            result += arr[i][0];
            arr[i][2] = 1;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                else {
                    return o2[0] - o1[0];
                }
            }
        });

        int check_num = 0;
        for (int i = 0; i < N; i++) {
            if (check_num == M) {
                break;
            }
            if (arr[i][2] == 0) {
                result += arr[i][0];
                check_num++;
            }
        }
        System.out.println(result);
    }
}