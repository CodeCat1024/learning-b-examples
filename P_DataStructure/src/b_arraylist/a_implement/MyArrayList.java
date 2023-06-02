package b_arraylist.a_implement;
import java.util.Arrays;

/**
 * 模拟实现了 ArrayList 类
 */

public class MyArrayList {
    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;
    // 创建顺序表
    public MyArrayList() {
        this.elem = new int[10];
    }
    // 打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    // 插入元素（在末尾插入）
    public void add(int data){
        // 若顺序表已满则进行扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        this.elem[this.usedSize++] = data;
    }
    // 插入元素（在 pos 下标插入）
    public void add (int data, int pos) throws PosWrongfulException {
        // 判断下标是否合法
        if (pos < 0 || pos > size()) {
            throw new PosWrongfulException("抱歉，输入的下标不合法！");
        }
        // 若顺序表已满则进行扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        // 将 pos 下标后面的所有数据向后挪动一个位置
        // 做法1. 从前往后挪，这样会覆盖后面的数据，不可行
        /*
        for (int i = pos; i < size(); i++) {
            this.elem[i] = this.elem[i + 1];
        }
         */

        // 做法2. 从后往前挪
        for (int i = size() - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        // 插入数据
        this.elem[pos] = data;
        usedSize++;
    }
    // 判断顺序表是否已满
    public boolean isFull() {
        return size() >= this.elem.length;
    }
    // 获取有效元素个数
    public int size() {
        return this.usedSize;
    }
    // 判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < size(); i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < size(); i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int get(int pos) {
        // 判断顺序表是否为空
        if(isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        // 判断 pos 是否合法
        if (pos < 0 || pos >= size()) {
            throw new PosWrongfulException("抱歉，输入的下标不合法！");
        }
        return this.elem[pos];
    }
    // 判断顺序表是否为空
    public boolean isEmpty() {
        return size() == 0;
    }
    // 给 pos 位置的元素 更新 为 value
    public void set(int pos, int value) {
        // 判断顺序表是否为空
        if (isEmpty()) {
            throw new EmptyException("抱歉，顺序表为空！");
        }
        // 判断下标是否合法
        if (pos < 0 || pos >= size()) {
            throw new PosWrongfulException("抱歉，输入的下标不合法！");
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        // 判断顺序表是否为空
        if(isEmpty()) {
            throw new EmptyException("抱歉，顺序表为空！");
        }
        // 判断是否包含 key 并得到 key 的索引
        int index = indexOf(key);
        if(index == -1) {
            System.out.println("抱歉，要删除的数字不存在！");
            return;
        }
        // 把 key 后面出现的所有数据向前移动一位
        for (int i = index; i < size() - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        usedSize--;
    }
    // 清空顺序表
    public void clear() {
        // 不需要把所有位置都置空，因为插入的时候会自动对空间进行重置
        this.usedSize = 0;
    }
}