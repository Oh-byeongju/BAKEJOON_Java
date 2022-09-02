import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {

    public static int [] red;
    public static int [] blue;
    public static int [] green;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        red = new int[N];
        green = new int[N];
        blue = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i< N; i++){
            red[i] = Math.min(green[i-1] + red[i], blue[i-1] + red[i]);
            green[i] = Math.min(red[i-1] + green[i], blue[i-1] + green[i]);
            blue[i] = Math.min(green[i-1] + blue[i], red[i-1] + blue[i]);
        }

        System.out.println(Math.min(blue[N-1],Math.min(red[N-1],green[N-1])));
    }
}
