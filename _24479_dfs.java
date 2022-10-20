//22-10-19
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24479_dfs {
    static int N, M, cnt;
    public static int [] visted;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }
        cnt = 1;
        visted = new int[N+1];
        dfs(R);

        for(int i = 0; i < visted.length; i++){
            if(i != 0) {
                System.out.println(visted[i]);
            }
        }
    }

    public static void dfs(int x){
        visted[x] = cnt;

        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(visted[y] == 0){
                cnt = cnt + 1;
                dfs(y);
            }
        }
    }
}