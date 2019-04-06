package sample.SortCreate;

import java.util.ArrayList;
import java.util.Arrays;

public class heapSort {

    public static ArrayList<int[]> result = new ArrayList<int[]>();
    public String gettime(int flag,int[] num){
        long starttime = 0;
        long endtime = 0;
        starttime = System.nanoTime();
        getresult(flag,num);
        endtime = System.nanoTime();
        double time = (endtime-starttime)/1000000.0;
        return time+"ms";
    }
    public static ArrayList<int[]> getresult(int flag, int[] num){
        result.clear();
        sort(num, flag);
        return result;
    }

    public static void sort(int []arr,int flag){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length,flag);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j,flag);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length, int flag){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(flag == 0){
                if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                    k++;
                }
                if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                    arr[i] = arr[k];
                    i = k;
                }else{
                    break;
                }
            }
            else if (flag == 1){
                if(k+1<length && arr[k]>arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                    k++;
                }
                if(arr[k] < temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                    arr[i] = arr[k];
                    i = k;
                }else{
                    break;
                }
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
        int[] mid = new int[arr.length];
        System.arraycopy(arr,0,mid,0,arr.length);
        result.add(mid);
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}