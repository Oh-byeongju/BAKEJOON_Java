package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        int sum = 0;
        int [] count = new int[8001];
        int max_count = 0;
        ArrayList<Integer> count_result = new ArrayList<Integer>();
        int max = -4001;
        int min = 4001;

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            nums[i] = temp;
            sum = sum += temp;
            max = Math.max(max, temp);
            min = Math.min(min, temp);

            if (temp > 0){
                count[temp+4000]++;
                max_count = Math.max(max_count, count[temp+4000]);
            }

            else{
                count[Math.abs(temp)]++;
                max_count = Math.max(max_count, count[Math.abs(temp)]);
            }
        }

        Arrays.sort(nums);

        System.out.println(Math.round((double) sum / N));
        System.out.println(nums[(N/2)]);

        if (count[0] == max_count){
            count_result.add(0);
        }

        for (int i = 1; i < 4001; i++){
            if (count[i] == max_count){
                count_result.add(i-i-i);
            }
        }

        for (int i = 4001; i < 8001; i++){
            if (count[i] == max_count){
                count_result.add(i-4000);
            }
        }
        Collections.sort(count_result);

        if (count_result.size() == 1){
            System.out.println(count_result.get(0));
        }
        else{
            System.out.println(count_result.get(1));
        }

        if (max == min){
            System.out.println(0);
        }
        else if (max < 0){
            System.out.println(Math.abs(min) - Math.abs(max));
        }
        else{
            System.out.println(max-min);
        }
    }
}

