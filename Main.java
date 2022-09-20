import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] stack = new int[N];
        int size = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i =0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack[0] = arr[0];
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            cnt += 1;

            if (stack[size] < arr[i]){
                for (int j = 0; j < cnt; j++) {
                    sb.append(arr[i]).append(" ");
                }
                size++;
                stack[size] = arr[i];
                cnt = 0;
            }


        }


    }
}