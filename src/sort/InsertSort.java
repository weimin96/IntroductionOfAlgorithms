package sort;

/**
 * Created by 你的奥利奥 on 2017/6/18.
 */
//插入排序
public class InsertSort {

    //从小到大
    public static int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];//待插入的牌
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
        return a;
    }

    //从大到小
    public static int[] sortTwo(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];//待插入的牌
            int j = i - 1;
            while (j >= 0 && key > a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={5, 2, 4, 6, 1, 3};
        a= InsertSort.sort(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        a= InsertSort.sortTwo(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
}
