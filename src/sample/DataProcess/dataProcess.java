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
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != '#'){
                list.add(str.charAt(i)+"");
            }
        }
        String[] string = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] getCom(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<=(str.length()/2);i++){
            if((2*i+1) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+1)!='#'){
                list.add(str.charAt(i)+":f1 -> "+str.charAt(2*i+1)+":f1");
            }

            if((2*i+2) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+2)!='#'){
                list.add(str.charAt(i)+":f1 -> "+str.charAt(2*i+2)+":f1");
            }
        }
        String string[] = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] getPre(String str,String flag){
        ArrayList<String> list = new ArrayList<String>();
        BTree btree = new BTree(null);
        String[] test = new String[str.length()];
        for(int i=0;i<str.length();i++){
            test[i] = ""+str.charAt(i);
        }
        btree.CreateTree(test);
        String strnode = "";
        if(flag == "pre"){
            btree.preOrder(btree.getRoot());
            strnode = btree.prelist.toString();
        }
        if(flag == "in"){
            btree.inOrder(btree.getRoot());
            strnode = btree.inlist.toString();
        }
        if(flag == "post"){
            btree.postOrder(btree.getRoot());
            strnode = btree.postlist.toString();
        }
        //System.out.println(strnode);
        strnode = strnode.replace("#","");
        strnode = strnode.replace(", ","");
        strnode = strnode.replace("[","");
        strnode = strnode.replace("]","");
        String nodes[] = getSTNodesvalue(strnode);
        for(int i=0;i<nodes.length-1;i++){
            list.add(nodes[i+1]+":f0"+" -> "+nodes[i]+":f0");
        }
        String string[] = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] getPost(String str,String flag){
        ArrayList<String> list = new ArrayList<String>();
        BTree btree = new BTree(null);
        String[] test = new String[str.length()];
        for(int i=0;i<str.length();i++){
            test[i] = ""+str.charAt(i);
        }
        btree.CreateTree(test);
        String strnode = "";
        if(flag == "pre"){
            btree.preOrder(btree.getRoot());
            strnode = btree.prelist.toString();
        }
        if(flag == "in"){
            btree.inOrder(btree.getRoot());
            strnode = btree.inlist.toString();
        }
        if(flag == "post"){
            btree.postOrder(btree.getRoot());
            strnode = btree.postlist.toString();
        }
        //System.out.println(strnode);
        strnode = strnode.replace("#","");
        strnode = strnode.replace(", ","");
        strnode = strnode.replace("[","");
        strnode = strnode.replace("]","");
        //System.out.println(strnode);
        String gg[] = getgg(str);
        String hh[] = gethh(strnode);
        for(int i=0;i<hh.length;i++){
            //System.out.println(hh[i]);
            boolean temp = true;
            for(int j=0;j<gg.length;j++){
                if(hh[i].equals(gg[j])){
                    temp = false;
                    break;
                }
            }
            if(temp){
                list.add(hh[i].charAt(0)+":f2 -> "+hh[i].charAt(1)+":f0");
            }
        }
        String string[] = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] getgg(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<=(str.length()/2);i++){
            if((2*i+1) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+1)!='#'){
                list.add(str.charAt(i)+""+str.charAt(2*i+1));
            }

            if((2*i+2) < str.length() && str.charAt(i)!='#' && str.charAt(2*i+2)!='#'){
                list.add(str.charAt(i)+""+str.charAt(2*i+2));
            }
        }
        String string[] = new String[list.size()];
        list.toArray(string);
        return string;
    }
    public static String[] gethh(String str){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<str.length()-1;i++){
            list.add(str.charAt(i)+""+str.charAt(i+1));
        }
        String string[] = new String[list.size()];
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
