// 23-05-31 그래프 문제(DFS)
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _new_2668_dfs {

    static int N;
    static int [] arr;
    static boolean [] visit;
    static ArrayList<Integer> result;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[N+1];
        visit = new boolean[N+1];
        result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 모든 index 탐색
        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        // 정렬 후 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    // 문제의 핵심은 출발지의 index값이 dfs 마지막 배열의 값과 일치하는것
    // 1 2 3 4 5 6 7
    // 3 1 4 6 5 1 1
    // 위와같이 1번 index의 값이 3인경우 타고타고 들어가서 6번 index의 값이 1인것을 확인하면 사이클이 발생한 것
    // 모든 index를 출발점으로 하여 사이클이 형성됐을경우 마지막 값을 넣어주면 처음에 출발한 index를 결과 배열에 삽입하게 됨
    public static void dfs(int start, int target) {
        // 다음 목적지가 방문 안했을경우 ex) 3번 인덱스의 값이 3이 아닐경우
        if(!visit[arr[start]]) {
            // 방문처리
            visit[arr[start]] = true;

            // 처음 시작했을때 index값은 계속 넘겨주고 dfs 돌림
            dfs(arr[start], target);

            // 백트래킹 처럼 다돌고 false로 해주면 배열 재활용 가능(재선언 x)
            visit[arr[start]] = false;
        }

        // 사이클이 발생했다면 첫 index 값을 넣어줌
        if(arr[start] == target) {
            result.add(target);
        }
    }
}