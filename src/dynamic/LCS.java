package dynamic;

import java.util.Objects;

/**
 * Created by 你的奥利奥 on 2017/6/29.
 */
//最长公共子序列
public class LCS {
    public static int lcsLength(char[] x, char[] y, String[][] b) {
        int m = x.length-1;
        int n = y.length-1;
        int[][] c = new int[m + 1][n + 1];//记录a,b的最长公共子序列的长度
        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            c[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "x";
                } else if (c[i - 1][j] >= c[i][j - 1]) {//c[i][j]=max{c[i-1}[j],c[i][j-1]}
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "up";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "left";
                }
            }
        }
//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < c[i].length; j++) {
//                System.out.printf("%3d", c[i][j]);
//            }
//            System.out.println();
//        }
        return c[m][n];
    }

    public static void printLcs(int i,int j,char[] x,String[][] b){
        if (i==0||j==0){
            return;
        }
        if (Objects.equals(b[i][j], "x")){
            printLcs(i-1,j-1,x,b);
            System.out.print(x[i]);
        }else if (Objects.equals(b[i][j], "up")){
            printLcs(i-1,j,x,b);
        }else {
            printLcs(i,j-1,x,b);
        }
    }


    public static void main(String[] args) {
        char[] x = {'0','a', 'b', 'c', 'b', 'd', 'a', 'b'};
        char[] y = {'0','b', 'd', 'c', 'a', 'b', 'a'};
        String[][] b = new String[x.length+1][y.length+1];
        lcsLength(x, y, b);
//        for (int i = 0; i < x.length; i++) {
//            for (int j = 0; j < y.length; j++) {
//                System.out.printf("%6s", b[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(lcsLength(x, y, b)+"");
        printLcs(x.length-1,y.length-1,x,b);
    }
}
