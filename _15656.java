//22-10-23
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15656 {

    static int N, M;
    static boolean [] check;
    static int [] arr, nums;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        check = new boolean[N];
        arr = new int [M];

        DFS(0);
        System.out.print(sb);
    }
    public static void DFS(int depth){

        if (depth == M){
            for (int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++){
            arr[depth] = nums[i];
            DFS(depth + 1);
        }
    }
}
