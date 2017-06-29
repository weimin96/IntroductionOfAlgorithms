package dynamic;

/**
 * Created by 你的奥利奥 on 2017/6/27.
 */
//矩阵链乘法
public class Matrix {
    public static final int MAX = 100000;

    public static void matrixChainOrder(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;//矩阵数量
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }
        //l:长度
        for (int l = 2; l <= n; l++) {
            //i:行（开始）
            for (int i = 0; i < n - l + 1; i++) {
                //j:列（结束）
                int j = i + l - 1;
                m[i][j] = MAX;
                //k:断开位置
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k + 1;//s记录断开位置，矩阵从1开始
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] m = new int[p.length - 1][p.length - 1];
        int[][] s = new int[p.length - 1][p.length - 1];
        matrixChainOrder(p, m, s);
        for (int[] a : m) {
            for (int b : a) {
                System.out.printf("%8s", b);
            }
            System.out.println();
        }

        for (int[] a : s) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
