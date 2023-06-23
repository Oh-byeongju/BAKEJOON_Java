package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int max_width=0, max_height=0, max_w_idx=0, max_h_idx=0;

        int [] dist = new int[6];
        int [] dir = new int[6];

        for (int i = 0; i < 6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());

            if (dir[i] == 1 || dir[i] == 2){
                if (max_width < dist[i]){
                    max_width = dist[i];
                    max_w_idx = i;
                }
            }
            else{
                if (max_height < dist[i]){
                    max_height = dist[i];
                    max_h_idx = i;
                }
            }
        }
        int max_size = max_width * max_height;
        int min_size = dist[(max_w_idx + 3) % 6] * dist[(max_h_idx + 3) % 6];

        System.out.println((max_size-min_size)*K);
    }
}
