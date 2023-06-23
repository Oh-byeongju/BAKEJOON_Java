// 22-11-14
package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class _17479 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> normal = new HashMap<>();
        HashMap<String, Integer> special = new HashMap<>();
        HashMap<String, Integer> service = new HashMap<>();

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            String K = st.nextToken();
            Integer V = Integer.parseInt(st.nextToken());
            normal.put(K, V);
        }

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            String K = st.nextToken();
            Integer V = Integer.parseInt(st.nextToken());
            special.put(K, V);
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            String K = st.nextToken();
            service.put(K, 1);
        }

        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        long result = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (normal.containsKey(arr[i])) {
                result += normal.get(arr[i]);
                cnt++;
            }
        }

        if (cnt != N && result < 20000) {
            System.out.println("No");
            exit(0);
        }

        for (int i = 0; i < N; i++) {
            if (special.containsKey(arr[i])) {
                result += special.get(arr[i]);
                cnt++;
            }
        }

        if (cnt != N && result < 50000) {
            System.out.println("No");
            exit(0);
        }

        if (cnt+1 >= N) {
            System.out.println("Okay");
        }
        else {
            System.out.println("No");
        }
    }
}