package sample.SortCreate;

import java.util.ArrayList;

public class redixSort {
    /*public static void main(String[] args){
        int[] num = new int[10];
        int[] num1 = new int[10];
        for(int i=0;i<num.length;i++){
            num[i] = (int)(1+Math.random()*200);
            num1[i] = num[i];
            System.out.print(num[i]+" ");
        }
        System.out.print("\n\n");
        ArrayList<int[]> result = getresult(1,num);
        for(int[] mid : result){
            for(int i=0;i<mid.length;i++){
                System.out.print(mid[i]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(gettime(1,num1));
    }*/

    public static String gettime(int flag,int[] num){
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        getresult(flag,num);
        endtime = System.nanoTime();
        double time = (endtime-starttime)/1000000.0;
        return time+"ms";
    }
    public static ArrayList<int[]> getresult(int flag, int[] num){
        ArrayList<int[]> result = new ArrayList<>();
        int d = 0;
        for(int i=0;i<num.length;i++){
            int r = String.valueOf(num[i]).length();
            if(r > d){
                d = r;
            }
        }
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][num.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        if(flag == 0) {
            while (m <= d) {
                for (int i = 0; i < num.length; i++) {
                    int lsd = ((num[i] / n) % 10);
                    temp[lsd][order[lsd]] = num[i];
                    order[lsd]++;
                }
                for (int i = 0; i < 10; i++) {
                    if (order[i] != 0)
                        for (int j = 0; j < order[i]; j++) {
                            num[k] = temp[i][j];
                            k++;
                            int[] mid = new int[num.length];
                            System.arraycopy(num, 0, mid, 0, num.length);
                            result.add(mid);
                        }
                    order[i] = 0;
                }
                n *= 10;
                k = 0;
                m++;
            }
        }
        else if(flag == 1) {
            while (m <= d) {
                for (int i = 0; i < num.length; i++) {
                    int lsd = ((num[i] / n) % 10);
                    temp[lsd][order[lsd]] = num[i];
                    order[lsd]++;
                }
                for (int i = 9; i >= 0; i--) {
                    if (order[i] != 0)
                        for (int j = 0; j < order[i]; j++) {
                            num[k] = temp[i][j];
                            k++;
                            int[] mid = new int[num.length];
                            System.arraycopy(num, 0, mid, 0, num.length);
                            result.add(mid);
                        }
                    order[i] = 0;
                }
                n *= 10;
                k = 0;
                m++;
            }
        }
        return result;
    }
}
