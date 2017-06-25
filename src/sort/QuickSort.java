package sort;

import java.util.Random;

import utils.ArrayUtils;

/**
 * Created by 你的奥利奥 on 2017/6/25.
 */
//快速排序
public class QuickSort {
    /**
     * 数组划分
     *
     * @param a 待排序数组
     * @param p 起始点
     * @param r 结束点
     * @return 分界点
     */
    public static int partition(int[] a, int p, int r) {
        int x = a[r];//记录划分基准
        int i = p - 1;//i记录左子数组的末端位置
        for (int j = p; j < r; j++) {
            if (a[j] < x) {//若小于划分长度则将对应元素换过来
                i++;
                ArrayUtils.exchange(a, i, j);
            }
        }
        ArrayUtils.exchange(a, i + 1, r);
        System.out.print("x=" + x + "   ");
        ArrayUtils.printarray(a);
        return i + 1;
    }

    public static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    public static int partitionTwo(int[] a, int p, int r) {
        int x = a[p];
        int i = p;
        int j = r + 1;
        while (true) {
            while (a[++i] < x && i < r) ;
            while (a[--j] > x) ;
            if (i >= j)//i==j的情况：i=r=j,a[p+1...r]<x
                break;
            ArrayUtils.exchange(a, i, j);
        }
        ArrayUtils.exchange(a, j, p);
        System.out.print("x=" + x + "   ");
        ArrayUtils.printarray(a);
        return j;
    }

    public static void quickSortTwo(int[] a, int p, int r) {
        if (p < r) {
            int q = partitionTwo(a, p, r);
            quickSortTwo(a, p, q - 1);
            quickSortTwo(a, q + 1, r);
        }
    }

    public static int randoizedPartition(int[] a, int p, int r) {
        int i = new Random().nextInt(r) % (r - p + 1) + p;
        ArrayUtils.exchange(a, r, i);
        return partition(a, p, r);
    }

    public static void randoizeQuickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = randoizedPartition(a, p, r);
            randoizeQuickSort(a, p, q - 1);
            randoizeQuickSort(a, q + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 7, 9, 8, 1, 4, 6};
        int[] b = {2, 5, 3, 7, 9, 8, 1, 4, 6};
        int[] c = {2, 5, 3, 7, 9, 8, 1, 4, 6};
//        System.out.println("算法导论");
//        quickSort(a, 0, a.length - 1);
//        System.out.println("课本");
//        quickSortTwo(b, 0, b.length - 1);
        System.out.println("随机化");
        randoizeQuickSort(c, 0, c.length - 1);
    }
}
