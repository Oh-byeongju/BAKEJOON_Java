// 22-10-12
package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603 {

    public static int [] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());
            if (temp == 0) {
                System.out.print(sb);
                break;
            }
            arr = new int[temp];

            for (int i = 0; i < temp; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int [] temp_arr = new int[6];
            dfs(0, 0, temp_arr);
            sb.append("\n");
        }
    }

    public static void dfs(int start, int depth, int [] array){
        if (depth == 6){
            for (int i = 0; i < 6; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++){
            array[depth] =  arr[i];
            dfs(i + 1, depth + 1, array);
        }
    }
}

