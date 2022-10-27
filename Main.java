//22-10-27
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static int [] graph;
    public static int N, M, cnt;
    public static int [][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[101];
        visit = new int[101][101];
        cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A] = B;
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A] = B;
        }

        bfs(1);
        System.out.println(visit[100][0]);
    }

    public static void bfs(int A){
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);

        cycle:
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                int a = now + i;

                if (a <= 100 && visit[a][0] == 0){
                    if (graph[a] == 0) {

                        visit[a][0] = visit[now][0] + 1;
                        q.offer(a);

                        if (visit[now][1] != 0 && i == 6){
                            visit[now][1] = 0;
                            visit[now][0] = 0;
                        }
                    }
                    else {
                        visit[a][0] = visit[now][0] + 1;
                        visit[graph[a]][0] = visit[now][0] + 1;
                        visit[graph[a]][1] = visit[now][0] + 1;
                        q.offer(graph[a]);

                        if (visit[now][1] != 0 && i == 6){
                            visit[now][1] = 0;
                            visit[now][0] = 0;
                        }
                    }

                    if (visit[100][0] != 0){
                        break cycle;
                    }
                }
            }
        }
    }
}
