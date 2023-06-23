package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double R = Integer.parseInt(br.readLine());

        System.out.println(String.format("%.6f",R*R*Math.PI));
        System.out.println(String.format("%.6f", R*R*2));
    }
}
