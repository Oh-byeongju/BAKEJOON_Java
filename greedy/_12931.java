// 22-10-17
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _12931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int cnt = 0;

        while(true) {
            int check = 0;
            for (int i = 0; i < N; i++){
                if (arr[i] == 0){
                    check++;
                }
            }

            if (check == N){
                break;
            }

            if (arr[0] > 1){
                cnt += 1;
            }

            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1){
                    cnt += 1;
                }
                arr[i] = arr[i] / 2;
            }
        }
        System.out.println(cnt);
    }
}