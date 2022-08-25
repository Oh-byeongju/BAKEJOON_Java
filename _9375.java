import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i< T; i++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hmap = new HashMap<String, Integer>();
            int result = 1;

            for(int j = 0; j < N; j++){
                String str = br.readLine();
                String [] arr = str.split(" ");

                if (hmap.containsKey(arr[1])) {
                    hmap.put(arr[1], hmap.get(arr[1]) + 1);
                }
                else {
                    hmap.put(arr[1], 1);
                }
            }

            for (int val : hmap.values()){
                result = result * (val+1);
            }
            System.out.println(result-1);
        }
    }
}
