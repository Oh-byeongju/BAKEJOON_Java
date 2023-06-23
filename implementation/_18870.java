package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][3];
        int check = 0;
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        check = arr[0][0];
        arr[0][2] = count;

        for (int i = 1; i < N; i++) {
            if (check == arr[i][0]){
                arr[i][2] = count;
            }
            else{
                check = arr[i][0];
                count ++;
                arr[i][2] = count;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            sb.append(arr[i][2] + " ");
        }
        System.out.println(sb);
    }
}