// 23-06-17 그리디 문제
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class _new_1343_greedy {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char [] arr = str.toCharArray();
        int cnt = 0;

        // length가 1일경우 예외처리
        if (arr.length == 1 && arr[0] == '.') {
            System.out.println('.');
            exit(0);
        }
        if (arr.length == 1 && arr[0] == 'X') {
            System.out.println(-1);
            exit(0);
        }

        for (int i = 0; i < arr.length; i++) {
            // 막아야하는 곳이면 cnt 증가
            if (arr[i] == 'X') {
                cnt++;
            }

            // 더 이상 진행이 불가능한경우 예외처리
            if (cnt == 1 && arr[i] == '.') {
                System.out.println(-1);
                exit(0);
            }

            // 더 이상 진행이 불가능한경우 예외처리
            if (cnt == 1 && i + 1 == arr.length) {
                System.out.println(-1);
                exit(0);
            }

            // 2칸이 될경우 B로 채우고 cnt 초기화
            if (cnt == 2) {
                arr[i-1] = 'B';
                arr[i] = 'B';
                cnt = 0;
                // 내 바로앞 글자도 B일 경우 A로 전부 교체
                if (i - 2 > 0 && arr[i-2] == 'B') {
                    arr[i-3] = 'A';
                    arr[i-2] = 'A';
                    arr[i-1] = 'A';
                    arr[i] = 'A';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char alpha : arr) {
            sb.append(alpha);
        }
        System.out.println(sb);
    }
}