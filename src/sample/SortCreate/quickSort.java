package sample.SortCreate;

import java.util.ArrayList;

public class quickSort {

    public static String gettime(int flag,int[] num){
        ArrayList<int[]> result = new ArrayList<>();
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        quicksort(flag,0,num.length-1,num,result);
        endtime = System.nanoTime();
        double time = (endtime-starttime)/1000000.0;
        return time+"ms";
    }
    public static ArrayList<int[]> getresult(int flag, int[] num){
        ArrayList<int[]> result = new ArrayList<>();
        quicksort(flag,0,num.length-1,num,result);
        return result;
    }

    public static void quicksort(int flag,int left,int right,int[] num,ArrayList<int[]> result){
        int i,j,t,temp;
        if(left > right)
            return;

        temp = num[left];
        i = left;
        j = right;
        while(i != j){
            if(flag == 0) {
                while (num[j] >= temp && i < j) {
                    j--;
                }
                while (num[i] <= temp && i < j) {
                    i++;
                }
            }
            else if(flag == 1) {
                while (num[j] <= temp && i < j) {
                    j--;
                }
                while (num[i] >= temp && i < j) {
                    i++;
                }
            }
            if(i < j){
                t = num[i];
                num[i] = num[j];
                num[j] = t;
                int[] mid = new int[num.length];
                System.arraycopy(num,0,mid,0,num.length);
                result.add(mid);
            }
        }

        num[left] = num[i];
        num[i] = temp;

        int[] mid = new int[num.length];
        System.arraycopy(num,0,mid,0,num.length);
        result.add(mid);

        quicksort(flag,left,i-1,num,result);
        quicksort(flag,i+1,right,num,result);
    }
}
