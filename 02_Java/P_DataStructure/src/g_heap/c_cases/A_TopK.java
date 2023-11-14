package g_heap.c_cases;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top-K 问题：最小的 K 个数
 */
public class A_TopK {
    public static int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int x : arr) {
            minHeap.offer(x);
        }
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }
        return ret;
    }

    /**
     * N * logK
     * 1.遍历数组的前 K 个，放到堆当中
     * 2.遍历剩下的 K - 1 个，每次和堆顶元素进行比较
     * 3.堆顶元素小的时候就出堆
     */
    public static int[] maxK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int val = minHeap.peek();
            if (val < arr[i]) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 234, 231, 122, 14, 53, 3, 2, 66, 52};
        int[] ret = maxK(array, 4);
        System.out.println(Arrays.toString(ret));
    }
}
