package sample.SortCreate;

import java.util.ArrayList;

public class insertSort {
    /*public static void main(String[] args){
        int[] num = {9,8,7,6,5,4,3,2,1};
        int[] num1 = {9,8,7,6,5,4,3,2,1};
        ArrayList<int[]> result = getresult(0,num);
        for(int[] res:result){
            for(int i=0;i<res.length;i++){
                System.out.print(res[i]+" ");
            }
            System.out.print("\n");
        }
        System.out.println(gettime(0,num1));
    }*/

    public static String gettime(int flag,int[] num){
        int m = num.length;
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        getresult(flag,num);
        endtime = System.nanoTime();
        double time = (endtime-starttime)/1000000.0;
        return time+"ms";
    }
    public static ArrayList<int[]> getresult(int flag, int[] num){
        ArrayList<int[]> result = new ArrayList<int[]>();
        int m = num.length;
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
