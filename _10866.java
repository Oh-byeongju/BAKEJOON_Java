//22-09-23
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(N > 0){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.pollFirst()).append('\n');
                    }
                    break;

                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.pollLast()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.peekFirst()).append('\n');
                    }
                    break;

                case "back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dq.peekLast()).append('\n');
                    }
                    break;
            }
            N--;
        }
        System.out.print(sb);
    }
}