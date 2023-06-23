// 23-05-26 그래프 문제(DFS)
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _new_1325_dfs {
    static int N, M;
    static int max_num = 0;
    static boolean [] visited;
    static int [] result;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화 및 배열크기 설정
        graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        result = new int[N+1];

        // 그래프 값 설정(단방향으로 설정)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        // 모든 노드를 반복
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i);
        }

        // 최대값 추출
        for (int i = 1; i <= N; i++) {
            max_num = Math.max(max_num, result[i]);
        }

        // 결과값 가공 및 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max_num) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int x) {
        //방문 처리
        visited[x] = true;

        // 매개변수로 전달받은 노드에 모든간선을 loop
        for (int v : graph.get(x)) {
            // 방문하지 않은 노드일경우
            if (!visited[v]) {
                // 다음 노드에 cnt를 늘리고 재귀 호출
                result[v]++;
                dfs(v);
            }
        }
    }
}