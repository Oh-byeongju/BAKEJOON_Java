//22-11-03
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1389_bfs {

    public static int V, E, cnt;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int [] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int [] arr = new int[V+1];

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
        }

        arr[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {
            bfs(i);
            int result = 0;

            for (int j = 0; j <= V; j++) {
                result += visited[j];
            }
            arr[i] = result - V;
        }

        int temp = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i <= V; i++) {
            if (temp > arr[i]) {
                temp = arr[i];
                res = i;
            }
        }

        System.out.println(res);
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited = new int[V+1];
        visited[x] = 1; // 나중에 1 빼야함

        while(!queue.isEmpty()) {
            int q = queue.poll();

            for (int i = 0; i < graph.get(q).size(); i++){

                if (visited[graph.get(q).get(i)] != 0) {
                    continue;
                }

                visited[graph.get(q).get(i)] = visited[q] + 1;
                queue.add(graph.get(q).get(i));
            }
        }
    }
}
