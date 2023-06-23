// 22-11-15
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class _3613 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char [] arr = S.toCharArray();
        int check = 0;
        String [] arr2 = new String[S.length()];

        for (int i = 0; i < S.length(); i++) {
            arr2[i] = String.valueOf(S.charAt(i));
        }

        for (char c : arr) {
            if (Character.isUpperCase(c)) {
                check = 1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == '_' && arr[i] == '_') {
                System.out.println("Error!");
                exit(0);
            }
        }

        if (S.contains("_") && check == 1) {
            System.out.println("Error!");
            exit(0);
        }

        if (Character.isUpperCase(arr[0])) {
            System.out.println("Error!");
            exit(0);
        }

        if (arr[0] == '_' || arr[arr.length - 1] == '_') {
            System.out.println("Error!");
            exit(0);
        }

        if (S.contains("_")) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == '_') {
                    arr[i+1] = Character.toUpperCase(arr[i + 1]);
                    arr[i] = ' ';
                }
            }
            System.out.println(new String(arr).replace(" ", ""));
        }

        else {
            for (int i = 0; i < arr2.length; i++) {
                if (Character.isUpperCase(arr2[i].charAt(0))) { // 만약 대문자면
                    char temp = Character.toLowerCase(arr2[i].charAt(0));
                    arr2[i] = "_" + temp;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr2.length; i++) {
                sb.append(arr2[i]);
            }
            System.out.println(sb);
        }
    }
}
