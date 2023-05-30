// 23-05-30 그래프 문제(BFS)
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _new_16234_bfs {

    static int N, L, R;
    static int cnt, sum, result; // 연합국의 개수, 합계, 인구이동 요일
    static int [] dx, dy;
    static ArrayList<Integer> A, B; // 연합국 좌표
    static int [][] graph;
    static boolean [][] visit;
    static boolean run = true;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};
        result = 0;

        // 그래프 할당
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구 이동이 없을때까지 반복
        while(run) {
            visit = new boolean[N][N];
            run = false;

            // 모든 배열 반복 단, 이미 방문한곳은 x
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        bfs(i, j);

                        // 인접국가가 국경을 열었을경우
                        if (cnt > 1) {
                            graph[i][j] = sum / cnt;
                            run = true;
                            for (int k = 0; k < A.size(); k++) {
                                graph[A.get(k)][B.get(k)] = sum / cnt;
                            }
                        }
                    }
                }
            }
            if (run) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void bfs(int i, int j) {
        // 큐 선언
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));

        // 방문 처리 및 변수 초기화
        visit[i][j] = true;
        cnt = 1;
        sum = graph[i][j];
        A = new ArrayList<>();
        B = new ArrayList<>();
        A.add(i);
        B.add(j);

        while(!q.isEmpty()) {
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                int a = now.x + dy[k];
                int b = now.y + dx[k];

                // 움직일 수 있는 범위일경우
                if (0 <= a && a < N && 0 <= b && b < N) {
                    // 이미 방문 했으면 패스
                    if (visit[a][b]) {
                        continue;
                    }

                    // 국경이 열리는 조건인경우
                    if (L <= Math.abs(graph[now.x][now.y] - graph[a][b]) && Math.abs(graph[now.x][now.y] - graph[a][b]) <= R) {
                        cnt++;
                        sum += graph[a][b];
                        A.add(a);
                        B.add(b);
                        visit[a][b] = true;
                        q.offer(new Point(a, b));
                    }
                }
            }
        }
    }
}