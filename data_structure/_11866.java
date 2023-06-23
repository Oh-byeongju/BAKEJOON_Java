package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        for (int i = 1; i <= N; i++){
            q.offer(i);
        }

        while(true) {

            if (q.size() == 1){
                sb.append(q.poll()).append('>');
                break;
            }

            for (int i = 0; i < K; i++) {
                if (i == K-1){
                    Integer temp = q.poll();
                    sb.append(temp).append(", ");
                }
                else {
                    Integer temp2 = q.poll();
                    q.offer(temp2);
                }
            }
        }
        System.out.println(sb);
    }
}