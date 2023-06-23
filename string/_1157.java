package string;

import java.io.IOException;
import java.util.Scanner;

public class _1157 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[26];

        String S = sc.next();
        S = S.toLowerCase();

        int max_index = 0;
        int max_num = 0;
        int cnt = 0;

        for (int i = 0; i < S.length(); i++) {
            int temp = (S.charAt(i) - 'a');
            nums[temp] += 1;
        }

        for (int i = 0; i < 26; i++){
            if (nums[i] > max_num) {
                max_num = nums[i];
                max_index = i;
            }
        }

        for (int i = 0; i < 26; i++){
            if (nums[i] == max_num){
                cnt += 1;
            }
        }

        if (cnt >= 2){
            System.out.println("?");
        }
        else{
            System.out.printf("%c",max_index+65);
        }
    }
}
