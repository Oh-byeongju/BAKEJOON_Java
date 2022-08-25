import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][] nums = new int[N][2];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, (e1, e2) -> {
            if(e1[1] == e2[1]) {
                return e1[0] - e2[0];
            } else {
                return e1[1] - e2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< N ; i++) {
            sb.append(nums[i][0] + " " + nums[i][1] + "\n");

        }
        System.out.print(sb);
    }
}
