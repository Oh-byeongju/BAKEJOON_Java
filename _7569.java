//22-10-27
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _7569 {

    public static int [][][] graph;
    public static int M, N, H;
    public static int [][][] visit;
    public static int [] dx, dy, dh;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dy = new int[]{-1, 0, 1, 0, 0, 0};
        dx = new int[]{0, 1, 0, -1, 0, 0};
        dh = new int[]{0, 0, 0, 0, -1, 1};


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[N][M][H];
        visit = new int[N][M][H];

        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++){
                    graph[i][j][h] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<int []> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j][h] == 1) {
                        q.offer(new int[]{i, j, h});
                        visit[i][j][h] = 1;
                    }
                }
            }
        }

        bfs(q);
        int result = 0;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visit[i][j][h] == 0 && graph[i][j][h] == 0) {
                        System.out.println(-1);
                        exit(0);
                    }
                    result = Math.max(result, visit[i][j][h]);
                }
            }
        }
        System.out.println(result - 1);
    }

    public static void bfs(Queue<int[]> q){
        while (!q.isEmpty()) {
            int [] now = q.poll();

            for (int i = 0; i < 6; i++) {
                int a = now[0] + dy[i];
                int b = now[1] + dx[i];
                int c = now[2] + dh[i];

                if (0 <= a && a < N && 0 <= b && b < M && 0 <= c && c < H){
                    if (visit[a][b][c] != 0){
                        continue;
                    }

                    if (graph[a][b][c] == 0){
                        q.offer(new int[]{a,b,c});
                        visit[a][b][c] = visit[now[0]][now[1]][now[2]] + 1;
                    }
                }
            }
        }
    }
}
