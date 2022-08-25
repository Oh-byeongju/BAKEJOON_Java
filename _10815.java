import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] my_nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            my_nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int [] res_nums = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            res_nums[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(my_nums);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            sb.append(binarySearch(my_nums, res_nums[i], 0, N-1 ) + " ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int arr[], int key, int low, int high) {
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;

            if(key == arr[mid]) {
                return 1;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}