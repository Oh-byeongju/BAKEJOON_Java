// 22-10-20
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1260_dfs_bfs {

    public static int [] dfs_visited, dfs_result;
    public static int N, M, cnt;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs_visited = new int[N+1];
        dfs_result = new int[N+1];
        cnt = 0;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i <= N; i++) {
            if (dfs_result[i] != 0) {
                sb.append(dfs_result[i]).append(" ");
            }
        }

        int[] bfs_result = bfs(R);
        for (int i = 0; i <= N; i++) {
            if (bfs_result[i] != 0) {
                sb2.append(bfs_result[i]).append(" ");
            }
        }
        System.out.println(sb);
        System.out.println(sb2);
    }

    public static void dfs(int x){
        dfs_result[cnt] = x;
        dfs_visited[x] = x;

        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(dfs_visited[y] == 0){
                cnt = cnt + 1;
                dfs(y);
            }
        }
    }

    public static int [] bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        boolean [] visited = new boolean[N+1];
        visited[x] = true;

        int cnt = 0;
        int [] result = new int[N+1];

        while(!queue.isEmpty()) {
            int q = queue.poll();
            result[cnt] = q;
            cnt++;

            for (int i = 0; i < graph.get(q).size(); i++){
                if (!visited[graph.get(q).get(i)]) {
                    visited[graph.get(q).get(i)] = true;
                    queue.add(graph.get(q).get(i));
                }
            }
        }
        return result;
    }
}