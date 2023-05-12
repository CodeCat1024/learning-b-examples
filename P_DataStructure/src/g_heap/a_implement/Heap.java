package g_heap.a_implement;

import java.util.Arrays;

/**
 * 大堆的实现
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
    // 向下调整（参数分别是父亲下标和每棵树的结束下标，时间复杂度O(树的高度)）
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
    // 向上调整
    private void shiftUp(int child) {
        int parent = (child-1) / 2;
        while (child > 0) {//parent >= 0
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    // 插入数据（向上调整）
    // 向上调整建堆的时间复杂度： N * logN
    public void offer(int val) {
        if (isFull()) {
            // 扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
        // 进行向上调整
        shiftUp(usedSize - 1);
    }
    // 弹出数据
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;
        //保证他仍然是一棵大根堆
        shiftDown(0, usedSize);
        return tmp;
    }
    // 获取数据
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return elem[0];
    }
    // 是否已满
    public boolean isFull() {
        return usedSize == elem.length;
    }
    // 是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }



    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        heap.initElem(array);
        heap.createHeap();
        heap.offer(100);
        heap.pop();

    }
}
