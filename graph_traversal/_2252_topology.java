// 22-12-13
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2252_topology {

    public static int N, M;
    public static int [] degree, result;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        degree = new int[N+1];  // 진입차수
        result = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2); // 간선 저장
            degree[v2]++; // 진입 차수 저장
        }

        topology();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void topology() {
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.offer(i); // 집입 차수가 0이다 -> 바로 이수할 수 있다
            }
        }

        int cnt = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                int temp = queue.poll();
                result[cnt] = temp; // 이수 학기 저장

                for (int i = 0; i < graph.get(temp).size(); i++) {
                    int next = graph.get(temp).get(i); // 뽑은 정점에서 갈 수 있는 간선
                    degree[next] -= 1;
                    if (degree[next] == 0) {
                        queue.offer(next);
                    }
                }
                size--;
                cnt++;
            }
        }
    }
}