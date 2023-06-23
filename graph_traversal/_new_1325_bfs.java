// 23-05-26 그래프 문제(BFS)
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _new_1325_bfs {
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
            bfs(i);
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

    public static void bfs(int x) {
        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        // 큐가 비어있을때까지 반복
        while(!q.isEmpty()) {
            int num = q.poll();

            // 뽑아낸 노드를 기준으로 자식 노드들을 모두 탐색(너비 우선)
            for (int v : graph.get(num)) {
                // 방문안한 노드일경우 방문표시 해줌 + 해킹 가능한 cnt 증가
                if (!visited[v]) {
                    visited[v] = true;
                    result[v]++;
                    q.add(v);
                }
            }
        }
    }
}