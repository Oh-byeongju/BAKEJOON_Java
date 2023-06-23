// 22-10-12
package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        char [] ch = br.readLine().toCharArray();
        double [] arr_num = new double[N];

        for (int i = 0; i < N; i++){
            arr_num[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < ch.length; i++){
            if ((int) ch[i] - 65 >= 0  && (int) ch[i] - 65 <= 25) {
                stack.push(arr_num[(int) ch[i] - 65]);
            }

            else {
                double temp1 = 0;
                double temp2 = 0;
                double temp = 0;

                switch (ch[i]){
                    case '+':
                        temp1 = stack.pop();
                        temp2 = stack.pop();

                        temp = temp1 + temp2;
                        stack.push(temp);
                        break;

                    case '-':
                        temp1 = stack.pop();
                        temp2 = stack.pop();

                        temp = temp2 - temp1;
                        stack.push(temp);
                        break;

                    case '*':
                        temp1 = stack.pop();
                        temp2 = stack.pop();

                        temp = temp1 * temp2;
                        stack.push(temp);
                        break;

                    case '/':
                        temp1 = stack.pop();
                        temp2 = stack.pop();

                        temp = temp2 / temp1;
                        stack.push(temp);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f",stack.pop()));
    }
}

