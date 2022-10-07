//22-10-07
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12015 {
    public static int [] save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        save = new int [N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int check = 1;

        for (int i = 1; i <= N; i++){
            if (arr[i] > save[check-1]){
                save[check] = arr[i];
                check++;
            }
            else {
                int temp = lower_bound(arr[i], check);
                save[temp] = arr[i];
            }
        }
        if (check == 1){
            System.out.println(check);
        }
        else{
            System.out.println(check-1);
        }
    }

    public static int lower_bound(int num, int check) {
        int start = 0;
        int end = check;

        while (start < end) {
            int mid = (start + end) / 2;

            if (num <= save[mid]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}

