package sample.SortCreate;

import java.util.ArrayList;

public class selectSort {
    public String gettime(int flag,int[] num){
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        getresult(flag,num);
        endtime = System.nanoTime();
        double res = (endtime-starttime)/1000000.0;
        return res+"ms";
    }
    public ArrayList<int[]> getresult(int flag,int[] num){
        ArrayList<int[]> result = new ArrayList<>();
        int m = num.length;
        //升序
        if(flag == 0) {
            for (int i = 0; i < m - 1; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (num[i] > num[j]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                        int[] mid = new int[m];
                        System.arraycopy(num,0,mid,0,num.length);
                        result.add(mid);
                    }
                }
            }
        }
        //降序
        else if(flag == 1){
            for (int i = 0; i < m - 1; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (num[i] < num[j]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                        int[] mid = new int[m];
                        System.arraycopy(num,0,mid,0,num.length);
                        result.add(mid);
                    }
                }
            }
        }
        return result;
    }
}
