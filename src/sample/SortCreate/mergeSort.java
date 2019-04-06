package sample.SortCreate;

import java.util.ArrayList;

public class mergeSort {
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
        int m = num.length;
        result.clear();
        merges(num, 0, 1, flag);
        result.add(num);
        return result;
    }

    private static void mergeup(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    private static void mergedown(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] >= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    public static void merges(int[] a, int s, int len, int flag) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        //　-------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        //　------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            if(flag == 0){
                mergeup(a, s, s + len, (len << 1) + s - 1);
            }
            else if(flag == 1){
                mergedown(a, s, s + len, (len << 1) + s - 1);
            }
            int[] midd = new int[size];
            System.arraycopy(a,0,midd,0,a.length);
            result.add(midd);
        }

        //　-------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0) {
            if(flag == 0){
                mergeup(a, size - c - 2 * len, size - c, size - 1);
            }
            else if(flag == 1){
                mergedown(a, size - c - 2 * len, size - c, size - 1);
            }
        }
        //　-------递归执行下一趟归并排序------//
        merges(a, 0, 2 * len, flag);
    }
}