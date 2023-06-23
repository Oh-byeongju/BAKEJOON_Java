package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<Integer>();
        int sum = 0;

        for (int i = 0; i < 9; i++){
            arr.add(Integer.parseInt(br.readLine()));
            sum = sum + arr.get(i);
        }
        Collections.sort(arr);

        Test1 : for (int i = 0; i < 8; i++){
            for (int j = i+1; j < 9; j++){
                if (sum - arr.get(i) - arr.get(j) == 100){
                    int temp = arr.get(i);
                    int temp2 = arr.get(j);
                    arr.remove(Integer.valueOf(temp));
                    arr.remove(Integer.valueOf(temp2));
                    break Test1;
                }
            }
        }

        for(int val : arr){
            System.out.println(val);
        }

    }
}
