import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<Integer>();

        result = change_num(N);
        Collections.sort(result, Collections.reverseOrder());

        for(int val : result){
            System.out.print(val);
        }
    }

    public static ArrayList<Integer> change_num(int num){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(num != 0){
            nums.add(num%10);
            num /= 10;
        }
        return nums;
    }
}

