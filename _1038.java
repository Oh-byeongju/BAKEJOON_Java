//22-10-12
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _1038 {

    public static ArrayList<Long> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<Long>();

        if (N > 1022){
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = 0; i < 10; i++){
            cal (i, 1);
        }

        Collections.sort(arr);
        System.out.println(arr.get(N));
    }
    public static void cal(long num, int length){

        if (length > 10){
            return;
        }

        arr.add(num);

        for (int i = 0; i < 10; i++){
            if (num % 10 > i) {
                cal((num * 10) + i, length + 1);
            }
        }
    }
}

