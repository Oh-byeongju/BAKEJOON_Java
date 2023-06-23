package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];

        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int max_val = nums[1] - nums[0];

        for(int i = 2; i < N; i++) {
            max_val = GCD(max_val, nums[i] - nums[i - 1]);
        }

        for(int i = 2; i <= max_val; i++) {
            if(max_val% i == 0) {
                System.out.println(i);
            }
        }
    }
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
