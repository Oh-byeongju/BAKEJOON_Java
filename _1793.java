//22-12-07
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1793 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] arr = new BigInteger[251];

        arr[0] = BigInteger.valueOf(1);
        arr[1] = BigInteger.valueOf(1);
        arr[2] = BigInteger.valueOf(3);

        for (int i = 3; i < arr.length; i++) {
            BigInteger temp = arr[i-2].multiply(BigInteger.valueOf(2));
            BigInteger result = temp.add(arr[i-1]);
            arr[i] = result;
        }
        String str = "";

        while ((str =br.readLine()) != null) {
            int num = Integer.parseInt(str);
            System.out.println(arr[num]);
        }
    }
}
