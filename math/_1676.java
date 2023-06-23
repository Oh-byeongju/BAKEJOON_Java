package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N / 25;
        int temp2 = N / 125;

        System.out.println(N/5 + temp + temp2);
    }
}
