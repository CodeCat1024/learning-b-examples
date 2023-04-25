package b_arraylist;
import java.util.Arrays;

/**
 * 模拟实现了 ArrayList 类
 */
public class D_MyArrayList {
    private int[] elem;//数组
    private int usedSize;//记录有效的数据的个数
    private static final int DEFAULT_SIZE = 10;

    public D_MyArrayList() {
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

    // 判断顺序表是否已满
    public boolean isFull() {
        /*if(size() >= this.elem.length){
            return true;
        }
        return false;*/
        return size() >= this.elem.length;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

}