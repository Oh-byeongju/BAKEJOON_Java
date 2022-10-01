//22-10-01
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int result = -1;

        for (int i = 0; i < N; i++){
            int temp = arr[i] * (N-i);
            result = Math.max(result, temp);
        }
        System.out.println(result);

    }
}
