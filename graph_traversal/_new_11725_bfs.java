// 23-05-26 그래프 문제(BFS)
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _new_11725_bfs {
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

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        // 큐가 비어있을때까지 반복
        while(!q.isEmpty()) {
            int v = q.poll();

            // 뽑아낸 노드를 기준으로 자식 노드들을 모두 탐색(너비 우선)
            for (int next : graph.get(v)) {
                // 방문안한 노드일경우 방문표시 해줌 + 현재 노드 기준으로 아직 방문을 안했을경우 내가 부모니깐 parent를 체크 해주면됨
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = v;
                    // bfs 진행을 위해 방문 체크한 노드를 큐에 삽입
                    q.add(next);
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}