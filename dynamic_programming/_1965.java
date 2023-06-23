// 22-10-12
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1965 {

    static int [] arr;
    static int [] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        check = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check[1] = arr[1];
        int length = 1;

        for (int i = 2; i <= N; i++) {
            if (check[length] < arr[i]){
                length++;
                check[length] = arr[i];
            }
            else {
                int temp = lower(arr[i], length);
                check[temp] = arr[i];
            }
        }
        System.out.println(length);
    }

    public static int lower(int num, int length) {
        int start = 0;
        int end = length;

        while (start < end){
            int mid = (start + end) / 2;

            if (num <= check[mid]) {
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
}

