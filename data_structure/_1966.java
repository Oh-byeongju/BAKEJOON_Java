package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            Integer [] arr = new Integer[N];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                q.offer(new int[] {temp, j});
                arr[j] = temp;
            }

            int cnt = 0;
            Arrays.sort(arr, Collections.reverseOrder());

            while(true) {
                int [] tmp = q.poll();

                if (tmp[0] == arr[cnt]){
                    cnt++;
                    if (tmp[1] == M){
                        break;
                    }
                }
                else {
                    q.offer(tmp);
                }
            }
            System.out.println(cnt);
        }
    }
}
