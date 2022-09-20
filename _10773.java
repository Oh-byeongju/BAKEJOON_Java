import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10773 {

    public static int[] stack;
    public static int size;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stack = new int[N];
        size = 0;


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (size == 0){
                    stack[size] = 0;
                    size++;
                }
                else{
                    stack[size-1] = 0;
                    size--;
                }
            }
            else{
                stack[size] = num;
                size++;
            }
        }

        int result = 0;
        for (int j : stack) {
            result = result + j;
        }
        System.out.println(result);
    }
}

