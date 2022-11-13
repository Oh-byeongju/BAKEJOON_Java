//22-11-13
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2210 {

    public static int [] dx, dy;
    public static char [][] graph;
    public static HashSet<String> hash;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hash = new HashSet<>();
        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0 , -1};
        graph = new char[5][5];

        char [] array = new char[6];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, array, 0);
            }
        }
        System.out.println(hash.size());
    }

    public static void dfs(int A, int B, char [] arr, int depth) {
        if (depth == 6) {
            hash.add(new String(arr));
            return;
        }

        arr[depth] = graph[A][B];
        for (int i = 0; i < 4; i++) {
            int a = A + dy[i];
            int b = B + dx[i];

            if (0 <= a && a < 5 && 0 <= b && b < 5) {
                dfs(a, b, arr, depth + 1);
            }
        }
    }
}