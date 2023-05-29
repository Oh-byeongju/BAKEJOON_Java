// 23-05-29 그래프 문제(최단거리 BFS)
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _new_14940_bfs {

    static int N, M, X, Y;
    static int [] dx, dy;
    static int [][] graph;
    static int [][] visited;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new int[N][M];

        // 상하좌우 순서
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 목표지점 좌표 저장
                if (graph[i][j] == 2) {
                    Y = i;
                    X = j;
                }
            }
        }

        // 목표 지점에서 탐색 시작
        visited[Y][X] = 0;
        bfs(Y, X);

        // 결과값 가공
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(visited[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int i, int j) {
        // Point 이거 쓰면 배열처럼 int 두개 넣어짐
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        while (!q.isEmpty()) {
            Point now = q.poll();

            // 상하좌우 반복
            for (int k = 0; k < 4; k++) {
                int a = now.x + dy[k];
                int b = now.y + dx[k];

                // 그래프 안쪽일경우
                if (0 <= a && a < N && 0 <= b && b < M) {

                    // 이미 탐색한곳이면 continue
                    if (visited[a][b] != 0) {
                        continue;
                    }

                    // 움직일수 있는곳이면 결과값 지정
                    if (graph[a][b] == 1) {
                        visited[a][b] = visited[now.x][now.y] + 1;
                        q.offer(new Point(a, b));
                    }
                }
            }
        }
    }
}