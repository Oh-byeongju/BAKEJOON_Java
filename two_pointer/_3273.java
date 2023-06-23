// 22-12-15
package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int mid = arr[left] + arr[right];

            if (mid == num) {
                cnt++;
                right--;
                left++;
            }
            else if (mid > num) {
                right = right - 1;
            }
            else {
                left = left + 1;
            }
        }
        System.out.println(cnt);
    }
}