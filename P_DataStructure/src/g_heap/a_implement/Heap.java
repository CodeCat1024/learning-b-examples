package g_heap.a_implement;

/**
 * 小堆的实现
 * 时间复杂度：O(N)
 */
public class Heap {
    public int[] elem;
    public int usedSize;

    public Heap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++){
            elem[i] = array[i];
            usedSize++;
        }
    }

    public void createHeap() {
        for (int parent = (usedSize - 1 -1) / 2; parent >=0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    // 向下调整（参数分别是父亲下标和每棵树的结束下标）
    private void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        // 最起码要有左孩子
        while (child < len) {
            // 一定要有右孩子的情况下
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child++;
            }
            // 此时 child 下标一定是最大值的孩子的下标
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        heap.initElem(array);
        heap.createHeap();
        System.out.println("dfs");
    }
}
