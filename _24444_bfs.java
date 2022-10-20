//22-10-20
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _24444_bfs {
    static int N, M;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }
        bfs(R);
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        boolean [] visited = new boolean[N+1];
        visited[x] = true;

        int cnt = 0;
        int [] result = new int[N+1];

        while(!queue.isEmpty()) {
            int q = queue.poll();
            cnt++;
            result[q] = cnt;

            for (int i = 0; i < graph.get(q).size(); i++){
                if (!visited[graph.get(q).get(i)]) {
                    visited[graph.get(q).get(i)] = true;
                    queue.add(graph.get(q).get(i));
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}