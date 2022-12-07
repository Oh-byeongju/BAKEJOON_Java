//22-12-07
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _16174_bfs {

    public static int [][] graph;
    public static boolean [][] visit;
    public static int N;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0,0);
        System.out.println("Hing");
    }

    public static void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        visit[y][x] = true;
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            Point now;
            now = q.poll();

            for (int i = 0; i < 2; i++) {
                int a = now.x;
                int b = now.y;

                if (graph[a][b] == -1) {
                    System.out.println("HaruHaru");
                    exit(0);
                }

                if (i == 0) {
                    a = a + graph[a][b];
                } else {
                    b = b + graph[a][b];
                }

                if (0 <= a && a < N && 0 <= b && b < N) {
                    if (visit[a][b]) {
                        continue;
                    }
                    q.offer(new Point(a, b));
                    visit[a][b] = true;
                }
            }
        }
    }
}
