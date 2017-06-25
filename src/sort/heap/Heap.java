package sort.heap;

import utils.ArrayUtils;

/**
 * Created by 你的奥利奥 on 2017/6/22.
 */
//堆
public class Heap {

    public static int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    //维护堆（最大堆）
    public static void maxHeapify(int[] a, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < heapSize && a[l] > a[i]) {
            largest = l;
        } else
            largest = i;
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {//如果叶子节点largest比根节点i大
            ArrayUtils.exchange(a, largest, i);
            maxHeapify(a, largest, heapSize);
        }
    }

    //堆排序
    public static void heapExtractMax(int[] a) {
        for (int i = a.length-1; i >= 1; i--) {
            ArrayUtils.exchange(a, i, 0);//第0个与最后一个交换数值
            maxHeapify(a, 0, i);//此时数组a的有效长度已减少一位，构造最大堆
        }
    }

    public static void main(String[] args) {
        int[] a = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        System.out.println("最大堆");
        maxHeapify(a, 2, a.length);
        ArrayUtils.printarray(a);
        System.out.println("堆排序");
        heapExtractMax(a);
        ArrayUtils.printarray(a);
    }
}
