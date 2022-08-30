import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_Combination {

    static boolean [] check;
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        arr = new int [M];

        DFS(N, M, 1,0);

    }
    public static void DFS(int N, int M, int at, int depth){

        if (depth == M){
            for (int i =0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++){
            arr[depth] = i;
            DFS(N, M, i+1, depth+1);
        }
    }
}
