// 22-10-06
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110 {

    public static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1] - arr[0] + 1;
        // upper bound가 최대로 가질 수 있는 값은 +1이 되어야함

        while(start < end) {
            int mid = (start + end) / 2;

            if (Install(mid) < C){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(start-1);

    }
    public static int Install(int distance) {
        int cnt = 1;
        int last = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int locate = arr[i];

            if(locate - last >= distance) {
                cnt++;
                last = locate;
            }
        }
        return cnt;
    }
}
