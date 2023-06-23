package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651_OverPermutation {

    static boolean [] check;
    static int [] arr;
    static  StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        arr = new int [M];
        sb = new StringBuilder();

        DFS(N, M,0);
        System.out.print(sb);

    }
    public static void DFS(int N, int M, int depth){

        if (depth == M){
            for (int i =0; i < M; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++){
            arr[depth] = i;
            DFS(N, M, depth+1);
        }
    }
}
