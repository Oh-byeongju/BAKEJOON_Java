//22-10-11
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[10];

        arr[2] = 2;

        for (int i = 3; i <= N; i++){
            arr[i] = arr[i-1] * 3;
        }

        System.out.println(arr[N]);
    }
}

