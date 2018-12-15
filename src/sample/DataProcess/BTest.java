package sample.DataProcess;

public class BTest {
    public static void main(String[] args){
        //"ABCDE#FG#####HI"
        BTree btree = new BTree(null);
        String str = "ABCDE#FG#####HI";
        String[] test = new String[str.length()];
        for(int i=0;i<str.length();i++){
            test[i] = ""+str.charAt(i);
        }
        btree.CreateTree(test);
        btree.preOrder(btree.getRoot());
        btree.inOrder(btree.getRoot());
        btree.postOrder(btree.getRoot());
        System.out.println(btree.datas.toString());
        System.out.println(btree.prelist.toString());
        System.out.println(btree.inlist.toString());
        System.out.println(btree.postlist.toString());
    }

    public static void createsearch(String str){

    }
}
