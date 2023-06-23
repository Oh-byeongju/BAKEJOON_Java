package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr_x = new int[3];
        int [] arr_y = new int[3];
        int res_x = 0;
        int res_y = 0;

        for (int i = 0; i< 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr_x[i] = Integer.parseInt(st.nextToken());
            arr_y[i] = Integer.parseInt(st.nextToken());
        }

        if (arr_x[0] == arr_x[1]){
            res_x = arr_x[2];
        }
        else if(arr_x[0] == arr_x[2]){
            res_x = arr_x[1];
        }
        else{
            res_x = arr_x[0];
        }

        if (arr_y[0] == arr_y[1]){
            res_y = arr_y[2];
        }
        else if(arr_y[0] == arr_y[2]){
            res_y = arr_y[1];
        }
        else{
            res_y = arr_y[0];
        }
        System.out.printf("%d%c%d", res_x, ' ', res_y);
    }
}
