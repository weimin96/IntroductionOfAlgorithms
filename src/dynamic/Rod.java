package dynamic;

/**
 * Created by 你的奥利奥 on 2017/6/23.
 */
//钢管切割
public class Rod {
    /**
     * @param p 价格
     * @param n 铁块长度
     * @return 最大收益
     */
    public static int[] bottomUpCutRod(int[] p, int n) {
        //r[n]代表长度为n的铁块的最大收益
        int[] r = new int[n + 1];
        r[0] = 0;
        //j代表待分割铁块长度
        for (int j = 1; j <= n; j++) {
            int q = -100000;
            for (int i = 0; i < j; i++) {
                q = Math.max(q, p[i] + r[j - i - 1]);
            }
            r[j] = q;//记录最优解
        }
        return r;
    }

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        for (int i = 1; i <= 10; i++) {
            System.out.println(bottomUpCutRod(p, 10)[i]);
        }
    }
}
