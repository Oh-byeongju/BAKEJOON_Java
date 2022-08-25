import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean [] check;
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        arr = new int [M];

        DFS(N, M, 0);

    }
    public static void DFS(int N, int M, int depth){

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
                DFS(N, M, depth+1);
                if(depth == i){
                    check[i] = false;
                }
            }
        }
    }

}
