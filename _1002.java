import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int R1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());
            int R2 = Integer.parseInt(st.nextToken());

            // 좌표평면 위에 두좌표 사이의 거리
            double distance = Math.pow(X2 - X1, 2) + Math.pow(Y2 - Y1, 2);
            distance = Math.sqrt(distance);

            if(distance == 0 && R1 == R2) {
                System.out.println("-1");
            }
            else if(distance > R1 + R2 || distance < Math.abs(R1 - R2)){
                System.out.println("0");

            }
            else if(distance == R1 + R2 || distance == Math.abs(R1 - R2)){
                System.out.println("1");
            }
            else if(Math.abs(R1 - R2) < distance && Math.abs(R1 + R2) > distance){
                System.out.println("2");
            }
        }
    }
}
