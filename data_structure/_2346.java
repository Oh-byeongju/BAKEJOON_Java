// 22-12-26
package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<int []> dq = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int [] arr = new int[2];    // 0번이 풍선번호, 1번이 움직일 숫자
            arr[0] = i + 1;
            arr[1] = Integer.parseInt(st.nextToken());
            dq.addLast(arr);
        }

        StringBuilder sb = new StringBuilder();
        int [] temp = dq.pollFirst();
        sb.append(temp[0]).append(" ");
        int check = temp[1];

        for (int i = 0; i < N - 1; i++) {
            if (check > 0) {
                int run = check;

                if (run > N-i-1) {
                    run = run - (N-i-1);
                }

                for (int j = 0; j < run - 1; j++) {
                    temp = dq.pollFirst();
                    dq.addLast(temp);
                }
                temp = dq.pollFirst();
                check = temp[1];
                sb.append(temp[0]).append(" ");
            }
            else {
                int run = Math.abs(check);

                if (run > N-i-1) {
                    run = run - (N-i-1);
                }

                for (int j = 0; j < run - 1; j++) {
                    temp = dq.pollLast();
                    dq.addFirst(temp);
                }
                temp = dq.pollLast();
                check = temp[1];
                sb.append(temp[0]).append(" ");
            }
        }
        System.out.println(sb);
    }
}