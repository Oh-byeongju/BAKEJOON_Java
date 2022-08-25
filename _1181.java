import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class _1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<String>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String temp = br.readLine();
            set.add(temp);
        }

        ArrayList<String> word_list = new ArrayList<String>(set);

        Collections.sort(word_list,new Comparator<String>() {

            public int compare(String w1, String w2) {
                if (w1.length() == w2.length())
                    return w1.compareTo(w2);
                else
                    return w1.length() - w2.length();
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < word_list.size(); i++) {
            sb.append(word_list.get(i) + "\n");
        }
        System.out.print(sb);

    }
}