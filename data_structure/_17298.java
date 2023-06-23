package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17298 {
    public static int [] arr;
    public static int [] stack;
    public static int [] res;
    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        stack = new int[N];
        res = new int[N];
        size = 1;

        Arrays.fill(res, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack[0] = 0;

        for (int i = 1; i < N ; i++) {

            if (arr[i-1] < arr[i]){
                for (int j = size-1; j >= 0; j--){
                    if(arr[stack[j]] < arr[i]){
                        res[stack[j]] = arr[i];
                        pop();
                    }
                    else{
                        break;
                    }
                }
            }
            push(i);
        }

        for (int i = 0; i < N; i++){
            sb.append(res[i]).append(" ");
        }

        System.out.print(sb);

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