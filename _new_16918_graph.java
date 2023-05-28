// 23-05-28 그래프 문제(시뮬레이션)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _new_16918_graph {

    static int [][] graph;
    static int [] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0이 안전 1부터 폭탄 --> 폭탄이 터지는 시간에 따라 숫자가 바뀜(1이면 1초후 터진다는뜻)
        graph = new int[R][C];

        // x, y축 잘보기
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < R; i++) {
            char [] inputs = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = inputs[j] == '.' ? 0 : 2;
            }
        }

        for (int i = 2; i <= N; i++) {
            // 배열의 모든칸 탐색
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    // 짝수번째 반복일 경우 빈땅에는 폭탄설치, 폭탄 count는 감소 후 continue
                    if (i % 2 == 0) {
                        if (graph[j][k] != 0) {
                            graph[j][k]--;
                        }
                        graph[j][k] = graph[j][k] == 0 ? 3 : graph[j][k];
                        continue;
                    }

                    // 현재 폭탄이 터지는 타이밍이면
                    if (graph[j][k] == 1) {
                        // 현재칸을 파괴된 땅으로 변경
                        graph[j][k] = 0;

                        // 현재 칸에서 상하좌우 탐색
                        for (int l = 0; l < 4; l++) {
                            // 열
                            int a = j + dy[l];
                            // 행
                            int b = k + dx[l];

                            // 상하좌우의 위치가 그래프 안쪽일경우
                            if (0 <= a && a < R && 0 <= b && b < C) {
                                // 현재 터질 폭탄이 아니면 칸을 파괴된 땅으로 변경
                                if (graph[a][b] != 1) {
                                    graph[a][b] = 0;
                                }
                            }
                        }
                    }
                    // 현재 폭탄 카운트 1 down
                    if (graph[j][k] != 0) {
                        graph[j][k]--;
                    }
                }
            }
        }
        // 출력값 매핑 후 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 0) {
                    sb.append(".");
                }
                else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}