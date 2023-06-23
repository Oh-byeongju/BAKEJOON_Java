package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012 {

    public static int [] stack;
    public static int size;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String S = br.readLine();
            char [] arr = S.toCharArray();

            stack = new int[arr.length];
            size = 0;
            int check = 0;

            for (int j = 0; j < arr.length; j++){
                if (arr[j] == '('){
                    push();
                }
                else {
                    int temp = pop();
                    if (temp == -1){
                        check = 1;
                    }
                }
            }

            if (check == 0 && stack[0] == 0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    public static void push(){
        stack[size] = 1;
        size++;

    }

    public static int pop(){
        if (size == 0){
            return -1;
        }
        else{
            stack[size-1] = 0;
            size--;
            return 0;
        }
    }
}

