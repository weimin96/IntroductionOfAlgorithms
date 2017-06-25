package sort.heap;

import utils.ArrayUtils;

/**
 * Created by 你的奥利奥 on 2017/6/23.
 */
public class PriorityQueue {
    //返回具有最大关键字的元素
    private int heapMaxiMun(int[] a) {
        return a[0];
    }

    //去掉并返回具有最大关键字的元素
    private int heapExtractMax(int[] a, int heapSize) {
        if (heapSize < 1) {
            System.out.println("error");
            return 0;
        }
        int max = a[0];
        a[0] = a[heapSize];
        Heap.maxHeapify(a, 0, heapSize - 1);
        return max;
    }

    //将元素i的关键字增加到key并构造最大堆
    private void heapIncreaseKey(int[] a, int i, int key) {
        if (key < a[i]) {
            System.out.println("error");
            return;
        }
        a[i] = key;
        while (i > 0 && a[i] > a[Heap.parent(i)]) {
            ArrayUtils.exchange(a, i, Heap.parent(i));
            i = Heap.parent(i);
        }
    }

    //插入新节点
    private void maxHeapInsert(int[] a, int key, int heapSize) {
        heapSize++;
        a[heapSize - 1] = -100000;
        heapIncreaseKey(a, heapSize - 1, key);
    }
}
