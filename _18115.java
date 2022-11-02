//22-10-30
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _18115 {

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int add_num = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N-1; i >=0; i--) {
            if (arr[i] == 1){
                dq.addFirst(add_num);
            }
            else if (arr[i] == 2) {
                int temp = dq.pollFirst();
                dq.addFirst(add_num);
                dq.addFirst(temp);
            }
            else {
                dq.addLast(add_num);
            }
            add_num++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(dq.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
