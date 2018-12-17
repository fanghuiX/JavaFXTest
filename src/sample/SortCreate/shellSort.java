package sample.SortCreate;

import java.util.ArrayList;

public class shellSort {
    /*public static void main(String[] args){
        int[] num = {9,8,7,6,5,4,3,2,1};
        int[] num1 = {9,8,7,6,5,4,3,2,1};
        ArrayList<int[]> result = getresult(0,num);
        for(int[] mid : result){
            for(int i=0;i<mid.length;i++){
                System.out.print(mid[i]+" ");
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
        int d = num.length;
        if (flag == 0){
            while(true)
            {
                d=d/2;
                for(int x=0;x<d;x++)
                {
                    for(int i=x+d;i<num.length;i=i+d)
                    {
                        int temp=num[i];
                        int j;
                        for(j=i-d;j>=0 && num[j]>temp;j=j-d)
                        {
                            num[j+d]=num[j];
                            int[] mid = new int[num.length];
                            System.arraycopy(num,0,mid,0,num.length);
                            result.add(mid);
                        }
                        num[j+d]=temp;
                        int[] mid = new int[num.length];
                        System.arraycopy(num,0,mid,0,num.length);
                        result.add(mid);
                    }
                }
                if(d==1)
                {
                    break;
                }
            }
        }
        else if (flag == 1){
            while(true)
            {
                d=d/2;
                for(int x=0;x<d;x++)
                {
                    for(int i=x+d;i<num.length;i=i+d)
                    {
                        int temp=num[i];
                        int j;
                        for(j=i-d;j>=0 && num[j]<temp;j=j-d)
                        {
                            num[j+d]=num[j];
                            int[] mid = new int[num.length];
                            System.arraycopy(num,0,mid,0,num.length);
                            result.add(mid);
                        }
                        num[j+d]=temp;
                        int[] mid = new int[num.length];
                        System.arraycopy(num,0,mid,0,num.length);
                        result.add(mid);
                    }
                }
                if(d==1)
                {
                    break;
                }
            }
        }
        return result;
    }
}
