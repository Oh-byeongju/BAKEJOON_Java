// 22-10-21
package graph_traversal;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1012_bfs {

    public static int[][] graph;
    public static boolean[][] visit;
    public static int[] dx, dy;
    public static int M, N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // x, y축 잘보기
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visit = new boolean[N][M];
            cnt = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b][a] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (graph[k][l] == 1 && !visit[k][l]) {
                        cnt = cnt + 1;
                        bfs(k, l);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int A, int B) {
        Queue<Point> q = new LinkedList<>();
        visit[A][B] = true;
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now;
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < N && 0 <= b && b < M) {
                    if (visit[a][b]) {
                        continue;
                    }

                    if (graph[a][b] == 1) {
                        q.offer(new Point(a, b));
                        visit[a][b] = true;
                    }
                }
            }
        }
    }
}