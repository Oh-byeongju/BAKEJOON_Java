//22-11-08
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9742 {

    public static char [] arr;
    public static int cnt, res_num;
    public static String result;

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            String value = st.nextToken();
            res_num = Integer.parseInt(st.nextToken());
            char [] char_arr = value.toCharArray();

            int check = fac(char_arr.length);

            if (res_num > check) {
                System.out.println(value + " " + res_num + " = No permutation");
                continue;
            }

            boolean [] visit = new boolean[char_arr.length];
            cnt = 0;
            result = "";
            arr = new char[char_arr.length];

            dfs(char_arr.length, 0, visit, char_arr);
            System.out.println(value + " " + res_num + " = " + result);
        }
    }

    public static int fac(int num) {
        if (num == 1) {
            return 1;
        }
        else {
            return num * fac(num - 1);
        }
    }

    public static void dfs(int num, int depth, boolean [] visit, char [] char_arr) {
        if (depth == num) {
            cnt += 1;
            if (cnt == res_num) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    sb.append(arr[i]);
                }
                result = sb.toString();
            }
            return;
        }

        for (int i = 0; i < num; i++) {
            if (!visit[i]) {
                arr[depth] = char_arr[i];
                visit[i] = true;
                dfs(num, depth + 1, visit, char_arr);
                visit[i] = false;
            }
        }
    }
}