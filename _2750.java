import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2750 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            nums[i] = temp;
        }

        for (int i = 0; i < N-1; i++){
            for (int j = 0; j < N-i-1; j++){
                if (nums[j] > nums[j+1]){
                    int temp_num;
                    temp_num = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp_num;
                }
            }
        }

        for (int val : nums){
            System.out.println(val);
        }
    }
}
