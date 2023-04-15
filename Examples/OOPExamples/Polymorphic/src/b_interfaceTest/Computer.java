package b_interfaceTest;

public class Computer {
    public void open() {
        System.out.println("开机！");
    }

    public void close() {
        System.out.println("关机！");
    }

    // 所欲的USB都可以在电脑上使用
    // 这里就不需要关心它是什么设备，反正都实现了USB这个规范标准
    public void useDevice(IUSB usb) {
        usb.openDevice();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.click();
        } else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.input();
        }
        usb.closeDevice();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(mouse);
        computer.useDevice(keyBoard);
    }
}
