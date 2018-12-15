package sample.DataProcess;

import java.util.ArrayList;
import java.util.List;

class BTree {
    BTree root;
    Object val;
    BTree left;
    BTree right;
    List<BTree> datas;
    ArrayList<Object> prelist = new ArrayList<Object>();
    ArrayList<Object> inlist = new ArrayList<Object>();
    ArrayList<Object> postlist = new ArrayList<Object>();
    public BTree(Object obj){
        this.val = obj;
    }
    public BTree getRoot(){
        return this.root;
    }
    //创建二叉树
    public void CreateTree(Object[] objs){
        datas = new ArrayList<BTree>();
        for(Object obj : objs){
            datas.add(new BTree(obj));
        }
        root = datas.get(0);
        for(int i=0;i<datas.size()/2;i++){
            if(datas.get(i).val!="#" && datas.get(2*i+1).val!="#"){
                datas.get(i).left = datas.get(2*i+1);
            }
            if((2*i+2)<datas.size() && datas.get(i).val!="#" && datas.get(2*i+2).val!="#"){
                datas.get(i).right = datas.get(2*i+2);
            }
        }
    }
    //二叉树的前序遍历
    public void preOrder(BTree root){
        if(root != null){
            prelist.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //中序遍历
    public void inOrder(BTree root){
        if(root != null){
            inOrder(root.left);
            inlist.add(root.val);
            inOrder(root.right);
        }
    }
    //后序遍历
    public void postOrder(BTree root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            postlist.add(root.val);
        }
    }
    //重写toString
    public String toString(){
        return ""+val;
    }
}
