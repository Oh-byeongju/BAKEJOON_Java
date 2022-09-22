import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++){
            q.offer(i);
        }

        while(q.size() != 1) {
            q.poll();
            Integer temp = q.poll();
            q.offer(temp);
        }

        System.out.print(q.peek());
    }
}