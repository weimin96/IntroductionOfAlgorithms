import sort.heap.Heap;

/**
 * Created by 你的奥利奥 on 2017/6/30.
 */
//最小生成树
public class MSL {
    public static void prim(int n, float[][] c) {
        float[] lowcost = new float[n];//记录某点轻量级边的权
        int[] closest = new int[n];//记录某点∈（v-s）最接近的邻接顶点∈s
        boolean[] s = new boolean[n];//s集合
        s[0] = true;
        //初始化
        for (int i = 1; i < n; i++) {
            lowcost[i] = c[0][i];//s中只有0顶点，所以c[0][i]均为顶点i的轻量级边
            closest[i] = 0;//当前0为其余顶点的最接近邻接顶点
            s[i] = false;//其余顶点均不在s集合内
        }
        for (int i = 0; i < n - 1; i++) {//循环n-1次，除了第0个节点，需要计算n-1次分别求得另外n-1个节点
            float min = Float.MAX_VALUE;
            int j = 0;
            for (int k = 1; k < n; k++) {//从第二个开始
                if (lowcost[k] < min && !s[k]) {
                    min = lowcost[k];//min记录最小的轻量级边的权
                    j = k;
                }
            }
            System.out.println(j + "," + closest[j]);
            s[j] = true;//s集加入j
            //再次初始化
            for (int k = 1; k < n; k++) {
                if (c[j][k] < lowcost[k] && !s[k]) {//j顶点加入后更新lowcost和closest
                    lowcost[k] = c[j][k];
                    closest[k] = j;
                }
            }
        }
    }


    public static void main(String[] args) {
        float max = 1000;
        float[][] c = {
                {max, 6, 1, 5, max, max},
                {6, max, 5, max, 3, max},
                {1, 5, max, 5, 6, 4},
                {5, max, 5, max, max, 2},
                {max, 3, 6, max, max, 6},
                {max, max, 4, 2, 6, max}
        };
        prim(c.length, c);
    }
}
