// 22-10-28
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16928_bfs {

    public static int [] graph;
    public static int N, M;
    public static int [] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[101];
        visit = new int[101];

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
        System.out.println(visit[100]);
    }

    public static void bfs(int A){
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);

        cycle:
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                int a = now + i;

                if (a <= 100 && visit[a] == 0){
                    if (graph[a] == 0) {
                        visit[a] = visit[now] + 1;
                        q.offer(a);
                    }
                    else {
                        if (visit[graph[a]] == 0) {
                            visit[graph[a]] = visit[now] + 1;
                            q.offer(graph[a]);
                        }
                    }

                    if (visit[100] != 0){
                        break cycle;
                    }
                }
            }
        }
    }
}
