package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int two = two(N) - two(N - K) - two(K);
        int five = five(N) - five(N - K) - five(K);

        System.out.println(Math.min(two,five));

    }
    static int five(int num){
        int cnt = 0;

        while(num >= 5){
            cnt += (num / 5);
            num = num / 5;
        }
        return  cnt;
    }

    static int two(int num){
        int cnt = 0;

        while(num >= 2){
            cnt += (num / 2);
            num = num / 2;
        }
        return  cnt;
    }

}
