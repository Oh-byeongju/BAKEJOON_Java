//22-12-09
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20206 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int X1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int Y1 = Integer.parseInt(st.nextToken());
        int Y2 = Integer.parseInt(st.nextToken());

        int DanMiny, DanMaxy;
        int pathMiny, pathMaxy;

        int T1 = -1 * A * X1 - C;
        int T2 = -1 * A * X2 - C;
        pathMiny = Math.min(T1, T2);
        pathMaxy = Math.max(T1, T2);

        T1 = B * Y1;
        T2 = B * Y2;
        DanMiny = Math.min(T1, T2);
        DanMaxy = Math.max(T1, T2);

        if (pathMiny >= DanMaxy || pathMaxy <= DanMiny)
            System.out.println("Lucky");
        else
            System.out.println("Poor");
    }
}
