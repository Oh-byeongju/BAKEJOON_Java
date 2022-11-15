//22-11-15
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15723_bfs {

    public static HashSet<Integer> result;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean [] visit;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int u = (int) st.nextToken().charAt(0) - 97;
            st.nextToken();
            int v = (int) st.nextToken().charAt(0) - 97;
            graph.get(u).add(v);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            visit = new boolean[26];
            result = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int start = (int) st.nextToken().charAt(0) - 97;
            st.nextToken();
            int end = (int) st.nextToken().charAt(0) - 97;
            bfs(start);

            if (result.contains(end)) {
                System.out.println("T");
            }
            else {
                System.out.println("F");
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;

        while(!queue.isEmpty()) {
            int q = queue.poll();

            for (int i = 0; i < graph.get(q).size(); i++){
                if (!visit[graph.get(q).get(i)]) {
                    visit[graph.get(q).get(i)] = true;
                    result.add(graph.get(q).get(i));
                    queue.add(graph.get(q).get(i));
                }
            }
        }
    }
}
