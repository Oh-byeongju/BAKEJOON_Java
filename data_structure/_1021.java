// 22-09-23
package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[K];

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){
            dq.addLast(i);
        }

        int check = 0;
        int cnt = 0;

        while(true){

            if (dq.peekFirst() == arr[check]){
                dq.pollFirst();
                check++;
                if (check == K){
                    break;
                }
                continue;
            }

            int temp_cnt = 0; // 앞으로 빼기
            int temp_cnt2 = 0; // 뒤로 빼기

            for (int i = 0; i < dq.size(); i++){
                dq.addLast(dq.pollFirst());
                temp_cnt += 1;

                if (dq.peekFirst() == arr[check]) {
                    for (int j = 0; j < temp_cnt; j++){
                        dq.addFirst(dq.pollLast());
                    }
                    break;
                }
            }

            for (int i = 0; i < dq.size(); i++){
                dq.addFirst(dq.pollLast());
                temp_cnt2 += 1;

                if (dq.peekFirst() == arr[check]){
                    for (int j = 0; j < temp_cnt2; j++){
                        dq.addLast(dq.pollFirst());
                    }
                    break;
                }
            }

            if (temp_cnt <= temp_cnt2) {
                for (int i = 0; i < temp_cnt; i++) {
                    dq.addLast(dq.pollFirst());
                }
                cnt += temp_cnt;
            }
            else {
                for (int j = 0; j < temp_cnt2; j++) {
                    dq.addFirst(dq.pollLast());
                }
                cnt += temp_cnt2;
            }
        }
        System.out.println(cnt);
    }
}