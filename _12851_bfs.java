//22-10-22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12851_bfs {

    public static int [] graph;
    public static int [] visit;
    public static int [] dx;
    public static int N, K, cnt, minVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dx = new int[]{-1, 1, 2};

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        graph = new int[100001];
        visit = new int[100001];
        minVal = Integer.MAX_VALUE;

        bfs(N);

        System.out.println(visit[K]-1);
        System.out.println(cnt);
    }

    public static void bfs(int A) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);
        visit[A] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (minVal < visit[temp]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int a = 0;

                if (dx[i] == 2){
                    a = temp * 2;
                }
                else {
                    a = temp + dx[i];
                }

                if (0 <= a && a < 100001) {

                    if (a == K){
                        minVal = visit[temp];
                        cnt++;
                    }

                    if (visit[a] == 0 || visit[a] == visit[temp] + 1) {
                        q.offer(a);
                        visit[a] = visit[temp] + 1;
                    }
                }
            }
        }
    }
}