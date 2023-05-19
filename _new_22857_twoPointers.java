// 23-05-19 투포인터 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_22857_twoPointers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int odd = 0;
        int even = 0;

        // 초기값 설정
        if (arr[0] % 2 == 0) {
            even++;
        }
        else {
            odd++;
        }
        int max_num = even;

        while(R >= L) {
            // 홀수 제거 가능수가 현재 누적 홀수보다 크거나 같을경우(Right를 넘길 수 있는경우)
            if (odd <= K) {
                // Right를 증가시키고 배열을 넘어갈경우 break
                R++;
                if (R >= N) {
                    break;
                }

                // 현재 배열의 홀짝에 따라 수를 증가
                if (arr[R] % 2 == 0) {
                    even++;
                }
                else {
                    odd++;
                }
                // 최대수 갱신
                max_num = Math.max(max_num, even);
            }
            // 현재 홀수 누적수가 더 클경우
            else {
                // 홀짝에 따라 수를 빼고 Left를 한칸 이동
                if (arr[L] % 2 == 0){
                    even--;
                }
                else {
                    odd--;
                }
                L++;
            }
        }
        System.out.println(max_num);
    }
}