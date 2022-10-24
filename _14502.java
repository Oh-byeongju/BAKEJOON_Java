//22-10-24
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502 {

    public static int [] dy, dx;
    public static int N, M, max_val;
    public static int [][] graph;
    public static int [][] temp_graph;
    public static boolean [][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0, -1};

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        temp_graph = new int[N][M];
        max_val = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        back(0, 0, 0);
        System.out.println(max_val);

    }

    public static void back(int at_x, int ax_y, int depth) {
        if (depth == 3) {

            visit = new boolean[N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++) {
                    temp_graph[i][j] = graph[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && temp_graph[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp_graph[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            max_val = Math.max(cnt, max_val);
            return;
        }

        for (int i = at_x; i < N; i++) {
            if (i == at_x) {
                for (int j = ax_y; j < M; j++) {
                    if (graph[i][j] == 0) {
                        graph[i][j] = 1;
                        back(i, j, depth + 1);
                        graph[i][j] = 0;
                    }
                }
            }
            else {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) {
                        graph[i][j] = 1;
                        back(i, j, depth + 1);
                        graph[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs(int A, int B) {
        visit[A][B] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < N && 0 <= b && b < M) {
                    if (visit[a][b]) {
                        continue;
                    }

                    if (temp_graph[a][b] == 0) {
                        q.offer(new Point(a, b));
                        temp_graph[a][b] = 2;
                        visit[a][b] = true;
                    }
                }
            }
        }
    }
}
