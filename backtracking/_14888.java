package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 {

    public static int max_num = -1000000001;
    public static int min_num = 1000000001;
    public static int N;
    public static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int [] op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(arr[0], op, 1);
        System.out.println(max_num);
        System.out.println(min_num);

    }

    public static void DFS(int num, int [] op, int depth){

        if (depth == N){
            max_num = Math.max(num, max_num);
            min_num = Math.min(num, min_num);
            return;
        }

        for (int i = 0; i < 4; i++){

            int temp = 0;
            if (i == 0 && op[i] != 0){
                temp = num;
                num = num + arr[depth];
                op[i] = op[i] - 1;
                DFS(num, op, depth+1);
                num = temp;
                op[i] = op[i] + 1;
            }

            if (i == 1 && op[i] != 0){
                temp = num;
                num = num - arr[depth];
                op[i] = op[i] - 1;
                DFS(num, op, depth+1);
                num = temp;
                op[i] = op[i] + 1;
            }

            if (i == 2 && op[i] != 0){
                temp = num;
                num = num * arr[depth];
                op[i] = op[i] - 1;
                DFS(num, op, depth+1);
                num = temp;
                op[i] = op[i] + 1;
            }

            if (i == 3 && op[i] != 0){
                temp = num;
                if (num < 0){
                    num = Math.abs(num);
                    num = num / arr[depth];
                    num = num * -1;
                }
                else{
                    num = num / arr[depth];
                }
                op[i] = op[i] - 1;
                DFS(num, op, depth+1);
                num = temp;
                op[i] = op[i] + 1;
            }

        }

    }
}
