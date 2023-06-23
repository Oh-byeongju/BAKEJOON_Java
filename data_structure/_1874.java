package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1874 {

    public static int [] stack;
    public static int size;
    public static int check;
    public static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        stack = new int[N+1];
        size = 1;
        num = 0;
        check = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(true) {
            if (arr[check] == stack[size-1]){
                sb.append('-').append('\n');
                pop();
                check = check + 1;
                if (check == N){
                    System.out.print(sb);
                    break;
                }
            }

            else {
                num = num + 1;
                if(num > N){
                    System.out.println("NO");
                    break;
                }
                push(num);
                sb.append('+').append('\n');
            }
        }
    }

    public static void push(int val){
        stack[size] = val;
        size++;
    }

    public static void pop(){
        stack[size-1] = 0;
        size--;
    }
}