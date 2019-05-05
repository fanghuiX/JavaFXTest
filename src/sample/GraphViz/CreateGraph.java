package sample.GraphViz;

//import java.util.Scanner;
import sample.DataProcess.dataProcess;

import java.io.File;

public class CreateGraph{
    public static String[] nodes =null;
    public static String[] bt = null;

    //选择要创建哪一种图形
    public void choice(int flag,String str){
        if(flag == 1){
            nodes = dataProcess.getNodeValue(str);
            bt = dataProcess.createCTree(str);
        }
        else if(flag == 2){
            nodes = dataProcess.getBTNodesvalue(str);
            bt = dataProcess.createBTree(str);
        }
        else if(flag == 3){
            nodes = dataProcess.getSTNodesvalue(str);
            bt = dataProcess.createSTree(str);
        }
        else if(flag == 4){
            nodes = dataProcess.getTsNodesvalue(str);
            bt = dataProcess.createTrees(str);
        }
        else{
            System.out.println("input error!");
        }
    }

    public void start(String[] nodes,String[] bt){
        bean ss = new bean();
        Graphviz gv = new Graphviz();
        //定义每个节点的style
        //颜色：red orange yellow green lightblue cyan purple
        //形状：33 3 4 5 6
        //填充：filled rounded
        //线条颜色：black red yellow lightblue cyan
        //箭头：none forward both
        String color = "lightblue";
        String sides = "33";
        String style = "filled";
        String lightcolor = "black";
        String head = "none";
        try{
            color = ss.getGcolor();
            sides = ss.getGsides();
            style = ss.getGstyle();
            lightcolor = ss.getGlightcolor();
            head = ss.getGhead();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String nodesty = "[shape = polygon, sides = "+sides+", peripheries = 1, color = "+color+", style = "+style+"]";
        String linesty = "[dir = "+head+", color = "+lightcolor+"]";

        gv.addln(gv.start_graph());//SATRT
        gv.addln("size =\"8,8\";");
        //设置节点的style
        for(int i=0;i<nodes.length;i++){
            gv.addln(nodes[i]+" "+nodesty);
        }
        for(int i=0;i<bt.length;i++){
            gv.addln(bt[i]+" "+linesty);
        }
        gv.addln(gv.end_graph());//END
        //节点之间的连接关系输出到控制台
        String dotSource = gv.getDotSource();
        //System.out.println(dotSource);
        //输出什么格式的图片(gif,dot,fig,pdf,ps,svg,png,plain)
        String type = "png";
        //输出到文件夹以及命名
        File out = new File("src/sample/JavaFXUI/out.png");
        //File out = new File("c:/eclipse.ws/graphviz-java-api/out." + type);    // Windows
        //System.out.println(out.getAbsolutePath());
        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    }

    /**
     * Read the DOT source from a file,
     * convert to image and store the image in the file system.
     */
    @SuppressWarnings("unused")
    public void start2(){
        //String input = dir + "/sample/simple.dot";
        String input = "c:/eclipse.ws/graphviz-java-api/sample/simple.dot";    // Windows

        Graphviz gv = new Graphviz();
        gv.readSource(input);
        System.out.println(gv.getDotSource());

        String type = "gif";
        File out = new File("C:/Users/fanghui/Desktop/GraphTest/simple." + type);   // Linux
        //File out = new File("c:/eclipse.ws/graphviz-java-api/tmp/simple." + type);   // Windows
        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
    }

    /*public static void main(String[] args){
        //树，二叉树，线索二叉树，森林
        //树（广义表表示）："A(B(E(K,L),F),C(G),D(H(M,N),I,J))";
        //二叉树（数组表示）："ABCDE#FG#####HI";
        //线索二叉树：
        //森林：多个广义表
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择要绘制的图形（输入数字回车后输入数据结构表示）：");
        System.out.println("1.树（例\"A(B(E(K,L),F),C(G),D(H(M,N(X(Y(Z)))),I,J))\"）");
        System.out.println("2.二叉树(例\"ABCDE#FG#####HI\")");
        System.out.println("3.线索二叉树");
        System.out.println("4.森林");
        int judge = scan.nextInt();
        String str = scan.next();
        CreateGraph p = new CreateGraph();
        p.choice(judge, str);
	   *//*for(String s:nodes){
		   System.out.print(s+" ");
	   }
	   System.out.print("\n");
	   for(String s:bt){
		   System.out.println(s);
	   }*//*
        //开始绘制图形
        p.start(nodes,bt);
        //打开生成的图片
        final Runtime runtime = Runtime.getRuntime();
        @SuppressWarnings("unused")
        Process process = null;
        final String cmd = "rundll32 url.dll FileProtocolHandler file://C:\\Users\\fanghui\\Desktop\\GraphTest\\out.gif";//要打开的文件路径。
        try {
            process = runtime.exec(cmd);
        } catch (final Exception e) {
            System.out.println("Error exec!");
        }
        //p.start2();
    }*/
}