package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(GCD(A, B));
        System.out.println(A * B / GCD(A, B));
    }
    public static int GCD(int a, int b){
        int temp = 0;
        int N;

        if (a < b){
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0){
            N = a % b;
            a = b;
            b = N;
        }
        return a;
    }
}
