package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [] check = new boolean[N];
        int [] arr = new int [M];

        DFS(arr, check, N, M, 0);

    }

    public static void DFS(int [] arr, boolean [] check, int N, int M, int depth){

        if (depth == M){
            for (int i =0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++){
            if(!check[i]){
                check[i] = true;
                arr[depth] = i+1;
                DFS(arr, check, N, M, depth+1);
                check[i] = false;
            }
        }
    }

}
