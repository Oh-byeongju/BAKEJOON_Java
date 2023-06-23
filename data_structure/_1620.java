package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String ,Integer> map1 = new HashMap<String ,Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(name, i);
            arr[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            boolean isNumeric = str.chars().allMatch(Character::isDigit); // 숫자인지 문자인지 확인

            if (isNumeric) {
                int key = Integer.parseInt(str);
                sb.append(arr[key]+ "\n");
            } else {
                sb.append(map1.get(str)+ "\n");
            }
        }
        System.out.print(sb);
    }
}
