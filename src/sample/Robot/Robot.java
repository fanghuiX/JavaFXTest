package sample.Robot;

import java.util.Scanner;

public class Robot {
    private static int MAXx = 1000;
    private static int MAXy = 1000;
    private static int MAXn = 100;
    private static int[][] board;
    private static int[] color;
    private static boolean[][] g;
    private static int[][] m;
    private static int[] po2;

    private static int n;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
/*7
0 0 2 2 1
0 2 1 6 2
2 0 4 2 1
1 2 4 3 2
1 3 3 6 1
4 0 6 3 1
3 3 6 6 2*/
        //输入有几个方块
        //n = input.nextInt();
        n = 7;
        int block[][] = {{0,0,2,2,1},{0,2,1,6,2},{2,0,4,2,1},{1,2,4,3,2},{1,3,3,6,1},
                {4,0,6,3,1},{3,3,6,6,2}};

        MAXn = n+1;
        color = new int[n];
        board = new int[MAXx+1][MAXy+1];
        po2 = new int[MAXn];
        g = new boolean[n][n];
        m = new int[n][1<<n];

        for(int i=0; i<n; i++)
            for(int j=0; j<1<<n; j++)
                m[i][j] = -1;

        for(int i=0; i<=MAXx; i++)
            for(int j=0; j<=MAXy; j++)
                board[i][j] = -1;

        po2[0] = 1;
        for(int i=1; i<MAXn; i++)
            po2[i]=po2[i-1]<<1;

        //输入每个方块的位置和颜色：y1,x1,y2,x2,c
        for(int i=0; i<n; i++){
            int x1,y1,x2,y2;
            /*x1 = input.nextInt();
            y1 = input.nextInt();
            x2 = input.nextInt();
            y2 = input.nextInt();
            color[i] = input.nextInt();*/
            x1 = block[i][0];
            y1 = block[i][1];
            x2 = block[i][2];
            y2 = block[i][3];
            color[i] = block[i][4];
            for(int j=x1; j<x2; j++)
                for(int k=y1; k<y2; k++)
                    board[j][k] = i;
        }

        for(int i=0; i<MAXx; i++){
            for(int j=0; j<MAXy; j++){
                if(board[i][j]>=0 && board[i+1][j]>=0 && board[i][j]!=board[i+1][j]){
                    g[board[i][j]][board[i+1][j]] = true;
                }
            }
        }

        comp();
    }

    private static void comp(){
        int opt = -1;
        for(int i=0; i<n; i++){
            System.out.println("从第"+i+"个小矩形开始喷漆");
            backtrack(i,po2[n]-1);
            if(opt<0 || opt>m[i][po2[n]-1]){
                opt = m[i][po2[n]-1];
            }
        }

        System.out.println(opt);
        System.out.println("ggggg");
        for(int ii=0;ii<m.length;ii++){
            for(int jj=0;jj<m[0].length;jj++){
                System.out.print(m[ii][jj]+" ");
            }
            System.out.println();
        }
    }

    private static void backtrack(int r, int p){
        if(m[r][p] >= 0) return;
        for(int i=0; i<n; i++)
            if(i!=r && ((p&po2[i])>0 && g[i][r])){
                m[r][p] = MAXx;
                return;
            }

        int np = p-po2[r];
        //System.out.println(np);
        if(np == 0) {
            m[r][p]=1;
        }
        else {
            System.out.println("hhhhhh");
            for(int i=0; i<n; i++)
                if((np&po2[i]) > 0){
                    //System.out.println(i);
                    backtrack(i,np);
                    System.out.println(i);
                    int v = m[i][np]+(color[r]==color[i]?0:1);
                    //System.out.println(v);
                    if(m[r][p]<0 || m[r][p]>v) {
                        m[r][p]=v;
                    }
                }
        }
        /*System.out.println("m");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }*/
    }
}
