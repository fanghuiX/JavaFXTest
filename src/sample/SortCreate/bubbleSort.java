package sample.SortCreate;

import java.util.ArrayList;

//冒泡排序
public class bubbleSort {
    public String gettime(int flag,int[] num){
        int m = num.length;
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        getresult(flag,num);
        endtime = System.nanoTime();
        double res = (endtime-starttime)/1000000.0;
        return res+"ms";
    }
    public static ArrayList<int[]> getresult(int flag,int[] num){
        ArrayList<int[]> result = new ArrayList<int[]>();
        int m = num.length;
        //升序
        if(flag == 0){
            for(int i=0;i<m;i++){
                for(int j=0;j<m-i-1;j++){
                    if(num[j] > num[j+1]){
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                        int[] mid = new int[m];
                        for(int k=0;k<m;k++){
                            mid[k] = num[k];
                        }
                        result.add(mid);
                    }
                }
            }
        }
        //降序
        else if(flag == 1){
            for(int i=0;i<m;i++){
                for(int j=0;j<m-i-1;j++){
                    if(num[j] < num[j+1]){
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                        int[] mid = new int[m];
                        for(int k=0;k<m;k++){
                            mid[k] = num[k];
                        }
                        result.add(mid);
                    }
                }
            }
        }
        return result;
    }
}
