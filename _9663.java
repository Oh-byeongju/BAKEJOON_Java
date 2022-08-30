import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {

    public static int N;
    public static int [] arr;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        DFS(0);
        System.out.println(cnt);
    }

    public static void DFS(int depth){

        if (depth == N){
            cnt += 1;
            return;
        }

        for (int i = 0; i < N; i++){
            arr[depth] = i;
            if (check(depth)){
                DFS(depth+1);
            }
        }
    }

    public static boolean check(int col){

        for(int i = 0; i < col; i++){
            if (arr[i] == arr[col]){
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
