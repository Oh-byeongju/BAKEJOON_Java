//22-10-04
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816_bound {

    public static int [] arr1;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            sb.append(max_ref(temp) - min_ref(temp)).append(" ");

        }
        System.out.println(sb);
    }

    public static int min_ref(int num){
        int start = 0;
        int end = N;

        while(start < end){
            int mid = (start + end) / 2;

            if(num <= arr1[mid]) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return start;

    }

    public static int max_ref(int num){
        int start = 0;
        int end = N;

        while(start < end){
            int mid = (start + end) / 2;

            if(num < arr1[mid]) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return start;

    }
}
