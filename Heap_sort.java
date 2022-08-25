import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap_sort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] res = new int[N];

        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            res[i] = temp;
        }

        sort(res, N);

        for(int i = 0; i < N; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void sort(int [] nums, int size) {
        if(size < 2) {
            return;
        }

        int parentIdx = getParent(size - 1);

        for(int i = parentIdx; i >= 0; i--) {
            heapify(nums, i, size - 1);
        }

        for(int i = size - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i - 1);
        }
    }

    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void heapify(int[] nums, int parentIdx, int lastIdx) {

        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            if (nums[leftChildIdx] > nums[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && nums[rightChildIdx] > nums[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(nums, parentIdx, largestIdx);
                parentIdx = largestIdx;
            }
            else {
                break;
            }
        }
    }
}
