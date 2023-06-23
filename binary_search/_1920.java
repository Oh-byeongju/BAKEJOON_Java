// 22-10-04
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int [] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        for (int i = 0; i < M; i++){
            int start = 0;
            int end = arr1.length - 1;
            int check = 0;

            while (start <= end) {

                int mid = (start + end) / 2;

                if (arr2[i] == arr1[mid]){
                    check = 1;
                    break;
                }

                if (arr2[i] > arr1[mid]){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }

            if (check == 0){
                System.out.println(check);
            }
            else{
                System.out.println(check);
            }
        }
    }
}
