// 22-10-23
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10026_dfs {

    public static String [][] graph;
    public static boolean [][] visit;
    public static int [] dx, dy;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0 , -1};
        graph = new String[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            char [] temp_arr = temp.toCharArray();
            for (int j = 0; j < N; j++){
                graph[i][j] = String.valueOf(temp_arr[j]);
            }
        }
        int cnt = 0;
        int cnt2 = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visit[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        visit = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visit[i][j]){
                    dfs2(i, j, graph[i][j]);
                    cnt2++;
                }
            }
        }

        System.out.print(cnt+" ");
        System.out.println(cnt2);
    }

    public static void dfs(int A, int B) {

        for (int i = 0; i < 4; i++) {
            int a = A + dy[i];
            int b = B + dx[i];

            if (0 <= a && a < N && 0 <= b && b < N) {
                if (visit[a][b]) {
                    continue;
                }

                if (graph[a][b].equals(graph[A][B])) {
                    visit[a][b] = true;
                    dfs(a, b);
                }
            }
        }
    }

    public static void dfs2(int A, int B, String key) {

        for (int i = 0; i < 4; i++) {
            int a = A + dy[i];
            int b = B + dx[i];

            if (0 <= a && a < N && 0 <= b && b < N) {
                if (visit[a][b]) {
                    continue;
                }

                if (key.equals("R") || key.equals("G")) {
                    if (graph[a][b].equals("R") || graph[a][b].equals("G")) {
                        visit[a][b] = true;
                        dfs2(a, b, key);
                    }
                }
                else {
                    if (graph[a][b].equals("B")){
                        visit[a][b] = true;
                        dfs2(a, b, key);
                    }
                }
            }
        }
    }
}
