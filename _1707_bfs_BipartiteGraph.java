//22-11-03
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707_bfs_BipartiteGraph {

    public static int V, E, check;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int [] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int T = 0; T < K; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수
            check = 0;
            int [] arr = new int[E];
            visited = new int[V+1];  // 0이면 안온거 1이면 레드 2면 그린

            graph = new ArrayList<>();

            for (int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
                arr[i] = u;
            }

            for (int i = 0; i < E; i++) {
                if (visited[arr[i]] == 0) {
                    bfs(arr[i]);
                }
            }

            if (check == 1){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = 1;

        while(!queue.isEmpty()) {
            int q = queue.poll();

            for (int i = 0; i < graph.get(q).size(); i++){

                if (visited[q] == visited[graph.get(q).get(i)]) {
                    check = 1;
                }

                if (visited[q] != visited[graph.get(q).get(i)] && visited[graph.get(q).get(i)] != 0) {
                    continue;
                }

                if (visited[q] == 1 && visited[graph.get(q).get(i)] == 0) {
                    visited[graph.get(q).get(i)] = 2;
                    queue.add(graph.get(q).get(i));
                }

                if (visited[q] == 2 && visited[graph.get(q).get(i)] == 0) {
                    visited[graph.get(q).get(i)] = 1;
                    queue.add(graph.get(q).get(i));
                }
            }
        }
    }
}
