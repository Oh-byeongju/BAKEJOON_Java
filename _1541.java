import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class _1541 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char [] arr = S.toCharArray();

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<String> op = new ArrayList<String>();
        ArrayList<Integer> total_nums = new ArrayList<Integer>();

        int start = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '+' || arr[i] == '-'){
                nums.add(Integer.parseInt(S.substring(start, i)));
                op.add(S.substring(i, i+1));
                start = i+1;
            }

            if (i == arr.length-1){
                nums.add(Integer.parseInt(S.substring(start, arr.length)));
            }
        }


        for (int i = 0; i < op.size(); i++){
            if (Objects.equals(op.get(i), "+")){
                nums.set(i+1, nums.get(i) + nums.get(i+1));
                nums.set(i, 0);
            }

            if (Objects.equals(op.get(i), "-")){
                total_nums.add(nums.get(i));
                cnt++;
            }

            if (i == op.size()-1) {
                total_nums.add(nums.get(i+1));
            }
        }

        if (cnt == 0){
            if (total_nums.size() == 0){
                System.out.println(nums.get(0));
            }
            else{
                System.out.println(total_nums.get(0));
            }
        }
        else{
            int result = total_nums.get(0);
            for (int i = 0; i < cnt; i++){
                result = result - total_nums.get(i+1);
            }
            System.out.println(result);
        }
    }
}

