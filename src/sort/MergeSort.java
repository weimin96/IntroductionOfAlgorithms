package sort;

import utils.ArrayUtils;

/**
 * Created by 你的奥利奥 on 2017/6/24.
 */
public class MergeSort {
    /**
     * 合并相邻两段序列
     * @param a 待排序序列
     * @param b 辅助合并序列
     * @param start 起始下标
     * @param mid 中间下标
     * @param end 结束下标
     */
    public void merge(int[] a, int[] b, int start, int mid, int end) {
        int i = start;//第一段序列的起始下标
        int j = mid + 1;//第二段序列的起始下标
        int k = start;//存放合并序列的起始下标
        //扫描第一、第二段序列直到任意一段结束
        while (i <= mid && j <= end) {
            //取出小的存放到合并序列
            if (a[i] > a[j]) {
                b[k++] = a[j++];
            } else {
                b[k++] = a[i++];
            }
        }
        //若第一段还没扫描完，则将余项添加到合并序列
        while (i <= mid) {
            b[k++] = a[i++];
        }
        //若第二段还没扫描完，则将余项添加到合并序列
        while (j <= end) {
            b[k++] = a[j++];
        }
    }

    /**
     *  合并排好序的相邻数组段
     * @param a 待排序序列
     * @param b 辅助合并序列
     * @param s 字表长度
     */
    public void mergePass(int[] a,int[] b,int s){
        int i;
        //合并大小为s的相邻子数组
        for (i = 0; i+2*s <= a.length; i+=2*s) {
            merge(a,b,i,i+s-1,i+2*s-1);
        }
        //剩下的元素少于2s
        if (i+s<a.length){//剩下的元素大于s
            merge(a,b,i,i+s-1,a.length-1);
        }else {//剩下的元素少于s
            for (int j=i;j<a.length;j++){
                b[j]=a[j];
            }
        }
        System.out.print("s="+s+"   ");
        ArrayUtils.printarray(b);
    }

    public void mergeSort(int[] a){
        int[] b=new int[a.length];
        int s=1;//s从1开始
        //s等于数组长度时完成排序
        while (s<a.length){
            //合并到数组b
            mergePass(a,b,s);//此时a没有发生改变，b进行了一次子长度为s的合并排序
            s+=s;
            //所以b变成了待排序数组，a则作为辅助数组
            mergePass(b,a,s);//合并到数组a
            s+=s;
        }
    }

    public static void main(String[] args) {
        int[] a={9,1,5,3,4,2,6,8,7,0};
        MergeSort sort=new MergeSort();
        sort.mergeSort(a);
    }
}
