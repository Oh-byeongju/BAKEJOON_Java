package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char [] arr = br.readLine().toCharArray();
        int Q = Integer.parseInt(br.readLine());
        int [][] check = new int[arr.length][26];

        check[0][(int)arr[0] - 97]++;

        for (int i = 1; i < arr.length; i++){
            int num = (int)arr[i] - 97;
            for (int j = 0; j < 26; j++){
                check[i][j] = check[i - 1][j];
            }
            check[i][num]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int num = (int)alpha - 97;
            if (L == 0){
                sb.append(check[R][num] + "\n");
            }
            else{
                sb.append(check[R][num] - check[L-1][num] + "\n");
            }
        }
        System.out.print(sb);
    }
}
