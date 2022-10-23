//22-10-23
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10026_bfs {

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
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        visit = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visit[i][j]){
                    bfs2(i, j, graph[i][j]);
                    cnt2++;
                }
            }
        }

        System.out.print(cnt+" ");
        System.out.println(cnt2);
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

                if (0 <= a && a < N && 0 <= b && b < N) {
                    if (visit[a][b]) {
                        continue;
                    }

                    if (graph[a][b].equals(graph[now.x][now.y])) {
                        q.offer(new Point(a,b));
                        visit[a][b] = true;
                    }
                }
            }
        }
    }

    public static void bfs2(int A, int B, String key) {
        visit[A][B] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = now.y + dx[i];      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)

                if (0 <= a && a < N && 0 <= b && b < N) {
                    if (visit[a][b]) {
                        continue;
                    }

                    if (key.equals("R") || key.equals("G")) {
                        if (graph[a][b].equals("R") || graph[a][b].equals("G")) {
                            q.offer(new Point(a,b));
                            visit[a][b] = true;
                        }
                    }
                    else {
                        if (graph[a][b].equals("B")){
                            q.offer(new Point(a,b));
                            visit[a][b] = true;
                        }
                    }
                }
            }
        }
    }
}
