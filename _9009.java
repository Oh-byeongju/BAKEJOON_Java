//22-12-07
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9009 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr = new int[46];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= 45; i++ ) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Integer> stack = new Stack<>();
            int temp = Integer.parseInt(br.readLine());

            for (int j = 45; j > 0; j--) {
                if (temp - arr[j] >= 0) {
                    stack.add(arr[j]);
                    temp = temp - arr[j];
                }

                if (temp == 0) {
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            int roll = stack.size();
            for (int j = 0; j < roll; j++) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);
        }
    }
}
