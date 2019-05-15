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
    public String getdelete(String str, int a){
        int[] num = getData(str);
        int flag = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<num.length;i++){
            if(num[i] == a){
                flag = i;
                break;
            }
        }
        if(flag == 0 && num[1]!=-999 && num[2]!= -999){
            if(num[11] != -999){
                num[0] = num[11];
                num[11] = -999;
            }
            else {
                if (num[5] == -999) {
                    num[0] = num[2];
                    num[2] = num[6];
                    num[5] = num[13];
                    num[6] = num[14];
                    num[13] = -999;
                    num[14] = -999;
                } else {
                    num[0] = num[5];
                    if (num[12] != -999) {
                        num[5] = num[12];
                        num[12] = -999;
                    } else {
                        num[5] = num[11];
                        num[11] = -999;
                    }
                }
            }
        }
        if((flag == 1 || flag == 2) && num[2*flag+1]!=-999 && num[2*flag+2]!=-999){
            if(num[4*flag+5]!= -999){
                num[flag] = num[4*flag+5];
                num[4*flag+5] = -999;
            }
            else {
                if (num[2*flag+2] != -999) {
                    num[flag] = num[2*flag+2];
                    num[2*flag+2] = num[4*flag+6];
                    num[4*flag+6] = -999;
                }
            }
        }
        if(flag==3 || flag==4 || flag==5 || flag==6){
            if(num[2*flag+2] != -999){
                num[flag] = num[2*flag+2];
                num[2*flag+2] = -999;
            }
        }
        for(int i=0;i<num.length;i++){
            if(num[i]!=-999){
                sb.append(num[i]+",");
            }
        }
        return sb.toString();
    }
}
