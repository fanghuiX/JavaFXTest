package sample.Robot;

import java.util.ArrayList;

public class Robot {
    private int MAXx = 1000;
    private int MAXy = 1000;
    private int MAXn = 100;
    private int[][] board;
    private int[] color;
    private boolean[][] g;
    private int[][] m;
    private int[] po2;
    private StringBuffer sb = new StringBuffer();
    private ArrayList<String> list = new ArrayList<>();
    private int n;
    private String str;
    public int times = 0;
    public Robot(int n,String str){
        this.n = n;
        this.str = str;
    }

    public ArrayList<String> getdata(){
/*7
0 0 2 2 1
0 2 1 6 2
2 0 4 2 1
1 2 4 3 2
1 3 3 6 1
4 0 6 3 1
3 3 6 6 2*/
/*13
0 0 3 3 1
3 0 4 2 2
4 0 5 2 1
3 2 4 5 1
4 2 5 3 2
4 3 5 6 2
2 3 3 4 1
0 3 2 4 2
0 4 1 8 3
1 4 3 5 2
1 5 4 6 3
1 6 3 8 1
3 6 5 8 1*/
        /*int block[][] = {{0,0,2,2,1},{0,2,1,6,2},{2,0,4,2,1},{1,2,4,3,2},{1,3,3,6,1},
                {4,0,6,3,1},{3,3,6,6,2},{6,6,8,8,3}};*/

        String[] string = str.split(",");
        int block[][] = new int[n][5];
        //System.out.println(n);
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                block[i][j] = Integer.parseInt(string[i*5+j]);
                //System.out.print(block[i][j]+" ");
            }
        }

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
            x1 = block[i][1];
            y1 = block[i][0];
            x2 = block[i][3];
            y2 = block[i][2];
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
        return list;
    }

    public void comp(){
        int opt = -1;
        for(int i=0; i<n; i++){
            //System.out.println("从第"+i+"个小矩形开始喷漆");
            sb = new StringBuffer("");
            backtrack(i,po2[n]-1);
            list.add(sb.toString());
            if(opt<0 || opt>m[i][po2[n]-1]){
                opt = m[i][po2[n]-1];
            }
        }
        //System.out.println(opt);
        times = opt;
        //return opt;
    }

    public void backtrack(int r, int p){
        if(m[r][p] >= 0) {
            //System.out.println("v:"+m[r][p]);
            return;
        }
        for(int i=0; i<n; i++)
            if(i!=r && ((p&po2[i])>0 && g[i][r])){
                //System.out.println(i+"  "+r);
                m[r][p] = MAXx;
                return;
            }

        int np = p-po2[r];
        //System.out.println(np);
        if(np == 0) {
            m[r][p]=1;
        }
        else {
            //sb = new StringBuffer("");
            sb.append(r+",");
            //System.out.println("r2: "+r);
            for(int i=0; i<n; i++)
                if((np&po2[i]) > 0){
                    //System.out.println("hhh"+i);
                    backtrack(i,np);
                    //System.out.println(r+" "+i);
                    sb.append(i+",");
                    int v = m[i][np]+(color[r]==color[i]?0:1);
                    if(m[r][p]<0 || m[r][p]>v) {
                        m[r][p]=v;
                    }
                }
            //System.out.println(sb.toString());
        }
    }

}
