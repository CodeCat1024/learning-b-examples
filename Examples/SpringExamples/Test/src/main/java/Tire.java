public class Tire {
    public int size;
    public String color;
    public void init(int size, String color) {
        this.size = size;
        this.color = color;
        System.out.println("轮子的尺寸是为" + this.size + "\n轮子的颜色为" + this.color);
    }
}
