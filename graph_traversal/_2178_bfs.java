// 22-10-21
package graph_traversal;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2178_bfs {

    public static int [][] graph;
    public static int [][] visit;
    public static int[] dx, dy;
    public static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // x, y축 잘보기
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            char [] temp_arr = temp.toCharArray();
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(temp_arr[j]));
            }
        }
        bfs(0, 0);
        System.out.println(visit[N-1][M-1]);
    }


    public static void bfs(int A, int B) {
        Queue<Point> q = new LinkedList<>();
        visit[A][B] = 1;
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now;
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < N && 0 <= b && b < M) {
                    if (visit[a][b] != 0) {
                        continue;
                    }

                    if (graph[a][b] == 1) {
                        q.offer(new Point(a, b));
                        visit[a][b] = visit[now.x][now.y] + 1;
                    }
                }
            }
        }
    }
}