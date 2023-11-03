// 23-10-27 그래프 문제(BFS)
package graph_traversal;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _new_1261_bfs {
    public static int[][] graph;
    public static int[][] visit;
    public static int[] dx, dy;
    public static int M, N;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // x, y축 잘보기
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new int[M][N];
        visit = new int[M][N];

        // visit 초기화
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = 999999;
            }
        }
        // 배열 초기화
        for (int i = 0; i < M; i++) {
            char [] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Character.getNumericValue(temp[j]);
            }
        }

        bfs(0, 0);
        System.out.println(visit[M-1][N-1] - 1);
    }

    public static void bfs(int A, int B) {
        Queue<Point> q = new LinkedList<>();
        visit[A][B] = 1;
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            // 큐의 제일위의값 추출
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < M && 0 <= b && b < N) {
                    // 벽이 없는 경우 들어가야하는 케이스
                    if (graph[a][b] == 0 && visit[a][b] > visit[now.x][now.y]) {
                        visit[a][b] = visit[now.x][now.y];
                        q.offer(new Point(a, b));
                        continue;
                    }

                    // 벽이 있는 경우 들어가야하는 케이스
                    if (graph[a][b] == 1 && visit[a][b] > visit[now.x][now.y] + 1) {
                        visit[a][b] = visit[now.x][now.y] + 1;
                        q.offer(new Point(a, b));
                    }
                }
            }
        }
    }
}
