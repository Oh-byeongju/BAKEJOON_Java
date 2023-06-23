package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] road = new int[N-1];
        int [] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long result = (long)price[0] * road[0];
        int min_price = price[0];

        for (int i = 1; i < N-1; i++){
            if (min_price > price[i]){
                result = result + (long)price[i] * road[i];
                min_price = price[i];
            }
            else{
                result = result + (long)min_price * road[i];
            }
        }
        System.out.println(result);

    }
}

