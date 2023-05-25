// 23-05-25 그래프 문제(DFS)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _new_11725_dfs {
    static int N;
    static boolean [] visited;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프 초기화 및 필요한 배열 초기화
        graph = new ArrayList<>();
        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        parent = new int[N+1];

        // 그래프 값 입력
        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }
    public static void dfs(int x) {
        // 방문 처리
        visited[x] = true;

        // 매개변수로 전달받은 노드에 모든간선을 loop
        for (int v : graph.get(x)) {
            // 방문 기록이 없을경우 재귀를 돌림
            if (!visited[v]) {
                // 핵심은 현재 노드 기준으로 아직 방문을 안했을경우 내가 부모니깐 parent를 체크 해주면됨
                parent[v] = x;
                dfs(v);
            }
        }
    }
}