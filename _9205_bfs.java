//22-12-23
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205_bfs {

    public static int [] dx;
    public static int [] dy;
    public static boolean [] check;
    public static int end_x, end_y, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int N = Integer.parseInt(br.readLine());

            dx = new int[N+1];
            dy = new int[N+1];
            check = new boolean[N+1];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x_start = Integer.parseInt(st.nextToken());
            int y_start = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());

                dx[i] = x1;
                dy[i] = y1;
            }

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            dx[N] = end_x;
            dy[N] = end_y;

            bfs(y_start, x_start);

            if (result == 1) {
                System.out.println("happy");
            }
            else{
                System.out.println("sad");
            }
            T--;
        }
    }
    public static void bfs(int A, int B) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(A, B));

        while (!q.isEmpty()) {
            Point now;
            now = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int a = Math.abs(now.x - dy[i]);      // 열행이 들어가는거라 생각 잘하기 now.x -> 열(앞에숫자)
                int b = Math.abs(now.y - dx[i]);      // 열행이 들어가는거라 생각 잘하기 now.y -> 행(뒤에숫자)
                int distance = a + b;

                if (distance < 1001) {
                    if (check[i]) {
                        continue;
                    }

                    if (dy[i] == end_y && dx[i] == end_x) {
                        result = 1;
                    }

                    q.offer(new Point(dy[i], dx[i]));
                    check[i] = true;
                }
            }
        }
    }
}