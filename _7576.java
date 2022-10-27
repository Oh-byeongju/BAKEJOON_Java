//22-10-27
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _7576 {

    public static int [][] graph;
    public static int M, N;
    public static int [][] visit;
    public static int [] dx, dy;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0, -1};

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (graph[i][j] == 1) {
                    q.offer(new Point(i, j));
                    visit[i][j] = 1;
                }
            }
        }
        bfs(q);
        int result = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0 && graph[i][j] == 0){
                    System.out.println(-1);
                    exit(0);
                }
                result = Math.max(result, visit[i][j]);
            }
        }
        System.out.println(result - 1);
    }

    public static void bfs(Queue<Point> q){
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];
                int b = now.y + dx[i];

                if (0 <= a && a < N && 0 <= b && b < M){
                    if (visit[a][b] != 0){
                        continue;
                    }

                    if (graph[a][b] == 0){
                        q.offer(new Point(a, b));
                        visit[a][b] = visit[now.x][now.y] + 1;
                    }
                }
            }
        }
    }
}
