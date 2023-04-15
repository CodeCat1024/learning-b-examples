package a_polymorphic;

/**
 * 继承和多态示例
 */

abstract class Shape {
    public abstract void draw();
}

class Rect extends Shape {

    @Override
    public void draw() {
        System.out.println("画矩形！");
    }
}

class Cycle extends Shape {

    @Override
    public void draw() {
        System.out.println("画圆圈");
    }
}

class Flower extends Shape {

    @Override
    public void draw() {
        System.out.println("画花");
    }
}

public class Polymorphic {
    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape[] shapes = {rect, cycle, flower};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}














