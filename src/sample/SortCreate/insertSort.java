package sample.SortCreate;

import java.util.ArrayList;

public class insertSort {

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
        if(flag == 0){
        for(int i=1;i<num.length;i++) {
            if(num[i]<num[i-1])
            {
                int temp=num[i];
                int k = i - 1;
                for(int j=k;j>=0 && temp<num[j];j--)
                {
                    num[j+1]=num[j];
                    k--;
                    int[] mid = new int[num.length];
                    System.arraycopy(num,0,mid,0,num.length);
                    result.add(mid);
                }
                num[k+1]=temp;//插入第i位的值
                int[] mid = new int[num.length];
                System.arraycopy(num,0,mid,0,num.length);
                result.add(mid);
            }
        }
        }
        else if(flag == 1){
            for(int i=1;i<num.length;i++) {
                if(num[i]>num[i-1])
                {
                    int temp=num[i];
                    int k = i - 1;
                    for(int j=k;j>=0 && temp>num[j];j--)
                    {
                        num[j+1]=num[j];
                        k--;
                        int[] mid = new int[num.length];
                        System.arraycopy(num,0,mid,0,num.length);
                        result.add(mid);
                    }
                    num[k+1]=temp;//插入第i位的值
                    int[] mid = new int[num.length];
                    System.arraycopy(num,0,mid,0,num.length);
                    result.add(mid);
                }
            }
        }
        return result;
    }
}
