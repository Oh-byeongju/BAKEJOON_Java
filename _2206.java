//22-11-02
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {

    public static int N, M, minVal;
    public static int [][] graph;
    public static int [][][] visit;
    public static int [] dx, dy;

    public static class Check {
        int x, y;
        boolean destroy;

        public Check(int x, int y, boolean destroy) {
            this.x = x;
            this.y = y;
            this.destroy = destroy;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dy = new int []{-1, 0, 1, 0};
        dx = new int []{0, 1, 0, -1};
        graph = new int[N][M];
        visit = new int[N][M][2];
        minVal = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String tmp_str = br.readLine();
            char [] arr = tmp_str.toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(arr[j]));
            }
        }

        // 0은 안뚫 1은 뚫
        visit[0][0][0] = 1;
        bfs(0, 0);

        if (visit[N-1][M-1][0] == 0 && visit[N-1][M-1][1] == 0) {
            System.out.println(-1);
        }
        else if (visit[N-1][M-1][0] == 0) {
            System.out.println(visit[N - 1][M - 1][1]);
        }
        else if (visit[N-1][M-1][1] == 0) {
            System.out.println(visit[N - 1][M - 1][0]);
        }
        else{
            System.out.println(Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]));
        }
    }

    public static void bfs(int A, int B) {
        Queue<Check> q = new LinkedList<>();
        q.offer(new Check(A, B, false));

        while(!q.isEmpty()) {
            Check now = q.poll();

            for (int i = 0; i < 4; i++) {
                int a = now.x + dy[i];
                int b = now.y + dx[i];

                if (0 <= a && a < N && 0 <= b && b < M) {
                    if (now.destroy) {
                        if (graph[a][b] == 1) {
                            continue;
                        }

                        if (visit[a][b][1] != 0) {
                            continue;
                        }

                        if (visit[a][b][0] != 0) {
                            continue;
                        }
                    }

                    if (!now.destroy) {
                        if (graph[a][b] == 1 && visit[a][b][1] != 0) {
                            continue;
                        }

                        if (graph[a][b] == 0 && visit[a][b][0] != 0) {
                            continue;
                        }
                    }

                    if (graph[a][b] == 0) {
                        if (now.destroy) {
                            q.offer(new Check(a, b, true));
                            visit[a][b][1] = visit[now.x][now.y][1] + 1;
                        }
                        else {
                            q.offer(new Check(a, b, false));
                            visit[a][b][0] = visit[now.x][now.y][0] + 1;
                        }
                    }

                    if (graph[a][b] == 1 && !now.destroy) {
                        q.offer(new Check(a, b, true));
                        visit[a][b][1] = visit[now.x][now.y][0] + 1;
                    }
                }
            }
        }
    }
}
