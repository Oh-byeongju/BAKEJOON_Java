package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] check_ans = new String[N];
        String[] search_ans = new String[M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            check_ans[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            search_ans[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++){
                if(search_ans[i].equals(check_ans[j])){
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}