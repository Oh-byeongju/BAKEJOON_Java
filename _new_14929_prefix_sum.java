// 23-06-22 누적합 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_14929_prefix_sum {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과값
        long result = 0;
        // 누적합에 대한 변수
        long sum = 0;

//        1, 2, 3, 4
//        1 * 2 + 1 * 3 + 1 * 4
//        2 * 3 + 2 * 4
//        3 * 4
//        1(2) + (1 + 2(3)) + (1 + 2 + 3(4))
//        특정 위치의 누적합을 구하려면 그 이전의 값들을 다 더한다음 곱셈을 해주면됨(곱셈을 하기전에 숫자들을 다 더한 후 한번에 하는 느낌)
        for (int i = 0; i < N - 1; i++) {
            sum += arr[i];
            result += arr[i + 1] * sum;
        }
        System.out.println(result);
    }
}