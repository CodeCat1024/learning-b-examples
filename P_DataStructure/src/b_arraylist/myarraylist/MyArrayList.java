package b_arraylist.myarraylist;
import java.util.Arrays;

/**
 * 模拟实现了 ArrayList 类
 */
public class MyArrayList {
    private int[] elem;//数组
    private int usedSize;//记录有效的数据的个数
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    // 打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //1. 检查当前的顺序表是不是满了？
        if(isFull()) {
            //2. 如果满了 就要进行扩容
            this.elem =
                    Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //3.
        this.elem[this.usedSize] = data;
        //4.
        this.usedSize++;
    }
    public boolean isFull() {
        /*if(size() >= this.elem.length){
            return true;
        }
        return false;*/
        return size() >= this.elem.length;
    }

    /**
     * 在 pos 位置新增元素
     * 如果pos下标不合法，那么就会抛出一个 PosWrongfulException
     */

    public void add(int pos, int data) throws PosWrongfulException{
        if(isFull()) {
            System.out.println("满了");
            this.elem =
                    Arrays.copyOf(this.elem,2*this.elem.length);
        }
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法！");
            throw new PosWrongfulException("pos位置不合法");
        }
        //pos一定是合法的
        //1. 开始挪动数据
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        //2.插入数据
        this.elem[pos] = data;
        //3. usedSize++
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.size(); i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int get(int pos) {
        if(isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        if(pos < 0 || pos >= this.usedSize) {
            throw new PosWrongfulException("get获取元素的时候，pos不合法异常！");
        }
        return this.elem[pos];
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    // 给 pos 位置的元素 更新 为 value
    public void set(int pos, int value) {
        if(isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        if(pos < 0 || pos >= this.usedSize) {
            throw new PosWrongfulException("set获取元素的时候，pos不合法异常！");
        }

        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        if(isEmpty()) {
            throw new EmptyException("顺序表为空！");
        }
        int index = this.indexOf(key);
        if(index == -1) {
            System.out.println("没有这个数字");
            return;
        }
        for (int i = index; i < size()-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        /*for (int i = 0; i < size(); i++) {
            this.elem[i] = null;
        }
        this.usedSize=0;*/
        this.usedSize=0;
    }
}