package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _4949 {

    public static char [] stack;
    public static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String S = br.readLine();

            if (S.equals(".")) {
                break;
            }

            char[] arr = S.toCharArray();

            stack = new char[arr.length];

            Arrays.fill(stack, '0');
            size = 0;
            int check = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] == '('){
                    push('(');
                }

                else if (arr[j] == '[') {
                    push('[');
                }

                if (arr[j] == ')')
                {
                    int temp = pop(')');
                    if (temp == -1){
                        check = 1;
                    }
                }
                else if (arr[j] == ']'){
                    int temp = pop(']');
                    if (temp == -1){
                        check = 1;
                    }
                }
            }

            if (check == 0 && stack[0] == '0') {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static void push(char word) {
        stack[size] = word;
        size++;
    }

    public static int pop(char word) {

        if (word == ')'){
            if (size == 0 || stack[size - 1] != '(') {
                return -1;
            }
            else {
                stack[size - 1] = '0';
                size--;
                return 0;
            }
        }
        else {
            if (size == 0 || stack[size - 1] != '[') {
                return -1;
            }
            else {
                stack[size - 1] = '0';
                size--;
                return 0;
            }
        }
    }
}


