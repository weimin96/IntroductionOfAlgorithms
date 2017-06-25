package utils;

/**
 * Created by 你的奥利奥 on 2017/6/23.
 */
public class ArrayUtils {

    public static void printarray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void exchange(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
