// 23-05-31 그래프 문제(BFS)
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class _new_17836_bfs {
    static int N, M, T;
    static int [] dx, dy;
    static int [][] graph;
    static int [][] visit;
    static int [][] sword_visit;
    static int sword_a, sword_b; // 검의 위치

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        // 그래프 초기화
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 검의 위치 기록
                if (graph[i][j] == 2) {
                    sword_a = i;
                    sword_b = j;
                }
            }
        }
        // bfs 탐색 시작
        // 출발지에서 출발, 검에서 출발
        bfs(0, 0);
        sword_bfs(sword_a, sword_b);

        // 검도 못잡고 도착도 못했을경우
        if (visit[sword_a][sword_b] == -1 && visit[N-1][M-1] == -1) {
            System.out.println("Fail");
            exit(0);
        }

        // 검없이 도착이 가능한경우 값 가공 아닐경우 MAX_VALUE
        int cnt = Integer.MAX_VALUE;
        if (visit[N-1][M-1] != -1) {
            cnt = visit[N-1][M-1];
        }

        // 검을 잡았을경우 값 가공 아닐경우 MAX_VALUE
        int sword_cnt = Integer.MAX_VALUE;
        if (visit[sword_a][sword_b] != -1) {
            sword_cnt = visit[sword_a][sword_b] + sword_visit[N-1][M-1];
        }

        // 최소값 구하기
        int result = Math.min(cnt, sword_cnt);

        // 구출성공
        if (result <= T) {
            System.out.println(result);
        }
        // 실패
        else {
            System.out.println("Fail");
        }
    }

    // 출발지에서 시작하는 bfs
    public static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        visit = new int[N][M];
        for (int k = 0; k < N; k++) {
            Arrays.fill(visit[k], -1);
        }
        visit[i][j] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                int a = now.x + dy[k];
                int b = now.y + dx[k];

                // 움직일 수 있을경우
                if (0 <= a && a < N && 0 <= b && b < M) {
                    // 이미 방문하면 continue
                    if (visit[a][b] != -1) {
                        continue;
                    }

                    // 벽이 아니면 방문기록을 넣음
                    if (graph[a][b] == 0 || graph[a][b] == 2) {
                        visit[a][b] = visit[now.x][now.y] + 1;
                        q.offer(new Point(a, b));
                    }
                }
            }
        }
    }

    // 검에서 출발하는 bfs
    public static void sword_bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        sword_visit = new int[N][M];
        for (int k = 0; k < N; k++) {
            Arrays.fill(sword_visit[k], -1);
        }
        sword_visit[i][j] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                int a = now.x + dy[k];
                int b = now.y + dx[k];

                // 움직일 수 있을경우
                if (0 <= a && a < N && 0 <= b && b < M) {
                    // 이미 방문하면 continue
                    if (sword_visit[a][b] != -1) {
                        continue;
                    }
                    // 검을 잡으면 모든곳을 움직이기 가능
                    sword_visit[a][b] = sword_visit[now.x][now.y] + 1;
                    q.offer(new Point(a, b));
                }
            }
        }
    }
}