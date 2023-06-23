// 22-10-21
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1012_dfs {

    public static int [][] graph;
    public static boolean [][] visit;
    public static int [] dx, dy;
    public static int M, N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // x, y축 잘보기
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visit = new boolean[N][M];
            cnt = 0;

            for (int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b][a] = 1;
            }

            for (int k = 0; k < N; k++){
                for (int l = 0; l < M; l++){
                    if(graph[k][l] == 1 && !visit[k][l]) {
                        cnt = cnt + 1;
                        dfs(k, l);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int y, int x){
        visit[y][x] = true;

        for (int i = 0; i < 4; i++){
            int a = y + dy[i];
            int b = x + dx[i];

            if (0 <= a && a < N && 0 <= b && b < M) {
                if (visit[a][b]) {
                    continue;
                }

                if (graph[a][b] == 1) {
                    dfs(a, b);
                }
            }
        }
    }
}