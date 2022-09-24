//22-09-24
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayDeque<Integer> rev_dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            char [] op = br.readLine().toCharArray();
            int num_cnt = Integer.parseInt(br.readLine());
            int check_num = 0;

            String str = br.readLine();
            str = str.replaceAll("\\[", "");
            str = str.replaceAll("]", "");
            String [] nums = str.split("\\,");

            boolean check = true;

            for (int j = 0; j < num_cnt; j++){
                dq.addLast(Integer.parseInt(nums[j]));
                rev_dq.addFirst(Integer.parseInt(nums[j]));
            }

            for (int k = 0; k < op.length; k++){
                if (op[k] == 'R'){
                    check = !check;
                    continue;
                }

                if (op[k] == 'D'){
                    if (check) {
                        Integer temp = dq.pollFirst();
                        if (temp == null){
                            sb.append("error").append("\n");
                            check_num = 1;
                            break;
                        }
                        rev_dq.pollLast();
                    }
                    else {
                        Integer temp2 = dq.pollLast();
                        if (temp2 == null){
                            sb.append("error").append("\n");
                            check_num = 1;
                            break;
                        }
                        rev_dq.pollFirst();
                    }
                }
            }

            if (check_num == 0) {

                if (dq.size() == 0) {
                    sb.append("[]").append("\n");
                }

                else if (check) {
                    sb.append("[");
                    int cnt = dq.size();
                    for (int l = 0; l < cnt; l++){
                        sb.append(dq.pollFirst()).append(",");
                    }
                    sb.setLength(sb.length() - 1);
                    sb.append("]").append("\n");
                }
                else {
                    sb.append("[");
                    int cnt2 = rev_dq.size();
                    for (int l = 0; l < cnt2; l++){
                        sb.append(rev_dq.pollFirst()).append(",");
                    }
                    sb.setLength(sb.length() - 1);
                    sb.append("]").append("\n");
                }
            }
            dq.clear();
            rev_dq.clear();
        }
        System.out.print(sb);
    }
}