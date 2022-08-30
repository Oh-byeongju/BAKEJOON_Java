import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean [] check;
    public static int [] combi_arr;
    public static int [][] arr;
    public static ArrayList<int[]> array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        array = new ArrayList<int[]>();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[N];
        combi_arr = new int[N/2];

        combi(N, N/2, 1,0);

        int totalElements = array.size();
        for (int index = 0; index < totalElements; index++) {
            System.out.println(array.get(index));
        }

    }

    public static void combi(int N, int M, int at, int depth){

        if (depth == M){
            System.out.println(Arrays.toString(combi_arr));
            array.add(combi_arr);
            return;
        }

        for (int i = at; i <= N; i++){
            combi_arr[depth] = i;
            combi(N, M, i+1, depth+1);
        }
    }
}
