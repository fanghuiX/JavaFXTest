package sample.SortCreate;

import java.util.ArrayList;

public class redixSort {
    public String gettime(int flag,int[] num){
        int m = num.length;
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();

        endtime = System.nanoTime();
        double time = (endtime-starttime)/1000000.0;
        return time+"ms";
    }
    public static ArrayList<int[]> getresult(int flag, int[] num){
        ArrayList<int[]> result = new ArrayList<int[]>();
        int m = num.length;

        return result;
    }
}
