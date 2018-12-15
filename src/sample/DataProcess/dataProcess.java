package sample.DataProcess;

import java.util.ArrayList;
//数据处理类
public class dataProcess {
    //树的广义表表示
    //得到广义表中每个节点的值
    public static String[] getNodeValue(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='('&&str.charAt(i)!=')'&&str.charAt(i)!=','){
                list.add(str.charAt(i)+"");
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
    /*将广义表格式A(B(E(K,L),F),C(G),D(H(M,N),I,J))转化为
    A -> B;A -> C;A -> D;
    B -> E;B -> F;
    E -> K;E -> L;
    C -> G;
    D -> H;D -> I;D -> J;
    H -> M;H -> N;*/
    public static String[] createCTree(String str){
        ArrayList<String> list = new ArrayList<String>();
        int leftk = 0;
        int rightk = 0;
        for(int i=0;i<str.length();i++){
            leftk = 0;
            rightk = 0;
            if(str.charAt(i)!='('&&str.charAt(i)!=')'&&str.charAt(i)!=','){
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(j) == '('){
                        leftk += 1;
                    }
                    else if(str.charAt(j) == ')'){
                        rightk += 1;
                    }
                    else if(str.charAt(j) == ','){
                        continue;
                    }
                    else{
                        if(leftk - rightk == 1){
                            String mid = str.charAt(i)+" -> "+str.charAt(j);
                            list.add(mid);
                        }
                        else if(leftk - rightk == 0){
                            break;
                        }
                    }
                }
            }
            else
                continue;
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }

    //二叉树的数组表示
    //得到二叉树的节点的值
    public static String[] getBTNodesvalue(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != '#'){
                list.add(str.charAt(i)+"");
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
    /*将数组形式"ABCDE#FG#####HI"转化为：
    A -> B;A -> C;
    B -> D;B -> E;
    C -> F;
    D -> G;
    F -> H;F -> I;*/
    public static String[] createBTree(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<=(str.length()/2);i++){
            if((2*i+1) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+1)!='#'){
                list.add(str.charAt(i)+" -> "+str.charAt(2*i+1));
            }

            if((2*i+2) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+2)!='#'){
                list.add(str.charAt(i)+" -> "+str.charAt(2*i+2));
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }

    //线索二叉树
    public static String[] getSTNodesvalue(String str){
        ArrayList<String> list = new ArrayList<String>();

        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] createSTree(String str){
        ArrayList<String> list = new ArrayList<String>();

        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }

    //森林,表示多个广义表用';'分割开来
    //例："A(B(E(K,L),F),C(G),D(H(M,N),I,J));X(Y,Z(P,Q));R(S(U),T(V))"
    public static String[] getTsNodesvalue(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='('&&str.charAt(i)!=')'&&str.charAt(i)!=','&&str.charAt(i)!=';'){
                list.add(str.charAt(i)+"");
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] createTrees(String str){
        ArrayList<String> list = new ArrayList<String>();
        String[] mid = str.split(";");
        for(int i=0;i<mid.length;i++){
            String[] res = createCTree(mid[i]);
            for(int j=0;j<res.length;j++){
                list.add(res[j]);
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
}
