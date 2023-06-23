// 22-11-03
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1707_dfs_BipartiteGraph {

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
                    dfs(arr[i], 1);
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

    public static void dfs(int x, int color) {
        visited[x] = color;

        for (int i = 0; i < graph.get(x).size(); i++){
            if (visited[x] == visited[graph.get(x).get(i)]) {
                check = 1;
            }

            if (visited[x] == 1 && visited[graph.get(x).get(i)] == 0) {
                dfs(graph.get(x).get(i), 2);
            }

            if (visited[x] == 2 && visited[graph.get(x).get(i)] == 0) {
                dfs(graph.get(x).get(i), 1);
            }
        }
    }
}
