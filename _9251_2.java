import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9251_2 {

    public static int [][] dp;
    public static char[] arr1;
    public static char[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        dp = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(LCS(arr1.length-1, arr2.length-1));
    }

    public static int LCS(int x, int y) {

        if(x == -1 || y == -1) {
            return 0;
        }

        if(dp[x][y] == -1) {
            dp[x][y] = 0;

            if(arr1[x] == arr2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            }

            else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return dp[x][y];
    }
}

