import java.io.IOException;
import java.util.Scanner;

public class _2675 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++){
            int A = sc.nextInt();
            String str = sc.next();

            for (int j = 0; j < str.length(); j++){
                for (int k = 0; k < A; k++){
                    System.out.print(str.charAt(j));
                }
            }

            System.out.println();
        }
    }
}