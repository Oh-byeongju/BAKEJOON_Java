//22-10-22
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int [] graph;
    public static int [] visit;
    public static String [] check;
    public static int [] dx;
    public static int N, K, minVal;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dx = new int[]{2, -1, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        if (N > K){
            System.out.println(N - K);
            for (int i = N; i >= K; i--){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        if (N * 2 > K){
            System.out.println(K - N);
        }

        graph = new int[100001];
        visit = new int[100001];
        check = new String[100001];
        minVal = Integer.MAX_VALUE;

        visit[N] = 1;
        check[N] = String.valueOf(N);
        bfs(N);

        System.out.println(visit[K] - 1);
        System.out.println(check[K]);
    }

    public static void bfs(int A) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);

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
                    }

                    if (visit[a] != 0) {
                        continue;
                    }
                    q.offer(a);
                    visit[a] = visit[temp] + 1;
                    check[a] = check[temp] + String.valueOf(a);
                }
            }
        }
    }
}
