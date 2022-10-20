//22-10-20
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2667_bfs {

    public static int N, cnt;
    public static int [] dx, dy;
    public static boolean [][] visited;
    public static int [][] arr;
    public static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        // 상우하좌
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            char [] temp_arr = temp.toCharArray();
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(temp_arr[j]));
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (arr[i][j] == 1 && !visited[i][j]){
                    cnt = 0;
                    bfs(i, j);
                    result.add(cnt);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Point(i, j));
        cnt += 1;

        while(!queue.isEmpty()) {
            Point now;
            now = queue.poll();

            for (int l = 0; l < 4; l++) {
                int nx = now.x + dx[l];
                int ny = now.y + dy[l];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[nx][ny]) {
                        continue;
                    }

                    if (arr[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny));
                        cnt += 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}