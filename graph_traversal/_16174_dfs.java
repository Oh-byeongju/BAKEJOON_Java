// 22-12-07
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _16174_dfs {

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
        dfs(0,0);
        System.out.println("Hing");
    }

    public static void dfs(int y, int x) {
        visit[y][x] = true;

        if (graph[y][x] == -1) {
            System.out.println("HaruHaru");
            exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int a = y;
            int b = x;

            if (i == 0) {
                a = a + graph[y][x];
            }
            else {
                b = b + graph[y][x];
            }

            if (0 <= a && a < N && 0 <= b && b < N) {
                if (visit[a][b]) {
                    continue;
                }
                dfs(a, b);
            }
        }
    }
}
