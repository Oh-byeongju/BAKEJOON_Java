import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(N > 0){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {

                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(item).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    Integer temp = q.peek();
                    if (temp == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(temp).append('\n');
                    }
                    break;

                case "back":
                    Integer temp2 = q.peekLast();
                    if (temp2 == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(temp2).append('\n');
                    }
                    break;
            }
            N--;
        }
        System.out.print(sb);
    }
}