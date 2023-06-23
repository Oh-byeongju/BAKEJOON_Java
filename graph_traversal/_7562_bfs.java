// 22-10-23
package graph_traversal;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _7562_bfs {

    public static int[][] graph;
    public static int[][] visit;
    public static int[] dx, dy;
    public static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            graph = new int[I][I];
            visit = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int now1 = Integer.parseInt(st.nextToken());
            int now2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int end1 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());

            bfs(now1, now2);
            System.out.println(visit[end1][end2] - 1);

        }
    }

    public static void bfs(int A, int B) {
        visit[A][B] = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 8; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < I && 0 <= b && b < I) {
                    if (visit[a][b] != 0) {
                        continue;
                    }
                    q.offer(new Point(a, b));
                    visit[a][b] = visit[now.x][now.y] + 1;
                }
            }
        }
    }
}
