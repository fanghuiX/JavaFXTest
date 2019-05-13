package sample.SearchBT;

public class dataProcess {
    /*public static void main(String[] args){
        String str = "4,9,2,6,5,3";
        int num[] = getData(str);
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }*/

    public int[] getData(String str){
        int num[] = new int[15];
        for(int i=0;i<num.length;i++){
            num[i] = -999;
        }
        String s[] = str.split(",");
        int mid[] = new int[s.length];
        for(int i=0;i<(s.length>15 ? 15 : s.length);i++){
            mid[i] = Integer.parseInt(s[i]);
        }
        for(int i=0;i<mid.length;i++){
            int j = 0;
            while (j<num.length){
                if(num[j] == -999){
                    num[j] = mid[i];
                    break;
                }
                if(mid[i] > num[j]){
                    j = 2*j+2;
                }
                else {
                    j = 2*j+1;
                }
            }
        }
        return num;
    }
}
