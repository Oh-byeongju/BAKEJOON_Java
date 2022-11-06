//22-11-06
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1049{

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] set_arr = new int[N];
        int [] solo_arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set_arr[i] = Integer.parseInt(st.nextToken());
            solo_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(set_arr);
        Arrays.sort(solo_arr);

        int set_num = M / 6;
        int set_remain = M % 6;
        int set_result;

        if (set_remain == 0) {
            set_result = set_arr[0] * set_num;
        }
        else {
            set_result = set_arr[0] * set_num + solo_arr[0] * set_remain;
        }

        int solo_result = solo_arr[0] * M;
        int all_set = set_arr[0] * (set_num + 1);

        System.out.println(Math.min(Math.min(set_result, solo_result),all_set));
    }
}