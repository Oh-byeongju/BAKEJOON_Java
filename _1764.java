import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String ,Integer> map1 = new HashMap<String ,Integer>();
        ArrayList <String> arr = new ArrayList<String>();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map1.put(name, i);
        }

        for (int i = 0; i < M; i++){
            String temp = br.readLine();
            if (map1.containsKey(temp)){
                cnt += 1;
                arr.add(temp);
            }
        }

        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i) + "\n");
        }

        System.out.println(cnt);
        System.out.print(sb);
    }
}
