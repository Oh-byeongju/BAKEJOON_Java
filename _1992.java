//22-09-24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {

    public static int [][] arr;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i ++){
            char [] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++){
                arr[i][j] = Character.getNumericValue(temp[j]);
            }
        }
        sb = new StringBuilder();
        cal(0,0,N);
        System.out.println(sb);
    }

    public static void cal (int x, int y , int N){

        int number = arr[x][y];

        for (int i = x; i < x + N; i++){
            for (int j = y; j < y + N; j++){
                if (number != arr[i][j]){
                    sb.append('(');
                    cal(x, y,N/2);
                    cal(x, y + N/2,N/2);
                    cal(x + N/2, y,N/2);
                    cal(x + N/2, y + N/2,N/2);
                    sb.append(')');
                    return;
                }
            }
        }
        sb.append(number);
    }
}
