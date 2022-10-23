//22-10-23
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15655 {

    static int N, M;
    static boolean [] check;
    static int [] arr, nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        check = new boolean[N];
        arr = new int [M];

        DFS(0, 0);
    }
    public static void DFS(int at, int depth){

        if (depth == M){
            for (int i = 0; i < M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i < N; i++){
            arr[depth] = nums[i];
            DFS(i + 1, depth + 1);
        }
    }
}
