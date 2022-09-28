//22-09-28
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr_plus = new int[50];
        int [] arr_minus = new int[50];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0){
                arr_plus[i] = temp;
            }
            else {
                arr_minus[i] = Math.abs(temp);
            }
        }

        Arrays.sort(arr_plus);
        Arrays.sort(arr_minus);

        int plus_temp = arr_plus[49];
        int minus_temp = arr_minus[49];
        int result = 0;

        int plus_start = 0;
        int minus_start = 0;

        if (plus_temp > minus_temp) {
            plus_start = 49 - M;
            minus_start = 49;
        }
        else{
            plus_start = 49;
            minus_start = 49 - M;
        }

        while(true){
            int temp_num_plus = 0;
            int temp_num_minus = 0;

            if (plus_start < 0) {
                plus_start = -1;
            }
            else {
                temp_num_plus = Math.abs(arr_plus[plus_start]);
            }

            if (minus_start < 0) {
                minus_start = -1;
            }
            else {
                temp_num_minus = Math.abs(arr_minus[minus_start]);
            }

            result += (temp_num_plus * 2) + (temp_num_minus * 2);

            if (minus_start == -1 && plus_start == -1){
                break;
            }

            plus_start -= M;
            minus_start -= M;
        }

        if (plus_temp > minus_temp){
            System.out.println(result + arr_plus[49]);
        }
        else{
            System.out.println(result + arr_minus[49]);
        }
    }
}
