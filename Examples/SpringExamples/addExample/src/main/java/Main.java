import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {100, 200, 300, 400};
        array1 = array2;
        array1[0] = 666;
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
