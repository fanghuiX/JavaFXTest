package sample.Robot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;


public class InputRobot extends Application {
    @FXML
    private TextField num;
    @FXML
    private TextArea position;

    private static String ssss = "";
    private static int time = 999;

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Robot/inputRobot.fxml"));
        primaryStage.setTitle("喷漆机器人输入数据");
        primaryStage.setScene(new Scene(root, 360, 300));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void clickok() throws Exception{
        String string = position.getText();
        string = string.replace(" ",",");
        string = string.replace("\n",",");
        int number = Integer.parseInt(num.getText());
        int temp = 0;
        String str[] = string.split(",");
        for(int i=0;i<str.length;i++){
            if(Integer.parseInt(str[i]) > temp){
                temp = Integer.parseInt(str[i]);
            }
        }
        //二维数组存储number个小矩形
        String[] blo = string.split(",");
        int block[][] = new int[number][5];
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                block[i][j] = Integer.parseInt(blo[i*5+j]);
            }
        }
        //记录最终结果
        String s = "0";
        Robot rb = new Robot(number,string);
        ArrayList<String> list = rb.getdata();
        //System.out.println(rb.times);
        //System.out.println(list.get(0));
        outer:for(String ss : list){
            //System.out.println(ss);
            String[] smid = ss.split(",");
            if(smid.length >= number){
                for(int i=1;i<smid.length-number+2;i++){
                    StringBuffer sb = new StringBuffer("");
                    sb.append(smid[0]);
                    for(int j=i;j<i+number-1;j++){
                        sb.append(","+smid[j]);
                    }
                    String sss = sb.toString();
                    //System.out.println(sss);
                    //System.out.println(orderNum(number,sss));
                    if(orderNum(number,sss)){
                        //System.out.println(sss);
                        if(getStr(rb.times,number,block,sss)){
                            s = sss;
                            //System.out.println(s);
                            break outer;
                        }
                        else{
                            s = sss;
                            //System.out.println(s);
                        }
                    }
                }
            }
        }
        new Main(temp*50+150, temp*50+100, number, string, s);
    }

    public void clickexample(){
        num.setText("7");
        position.setText("0 0 2 2 1"+"\n"+"2 0 6 1 2"+
                "\n"+"0 2 2 4 1"+"\n"+"2 1 3 4 2"+"\n"+
                "3 1 6 3 1"+"\n"+"0 4 3 6 1"+"\n"+
                "3 3 6 6 2");
    }

    public boolean orderNum(int n,String str){
        boolean flag[] = new boolean[n];
        for(int i=0;i<n;i++){
            flag[i] = false;
        }
        String[] string = str.split(",");
        for(int i=0;i<n;i++){
            for(int j=0;j<string.length;j++){
                if(i == Integer.parseInt(string[j])){
                    flag[i] = true;
                }
            }
        }
        boolean judge = true;
        for(int i=0;i<flag.length;i++){
            if(flag[i] == false){
                judge = false;
                break;
            }
        }
        return judge;
    }

    public boolean getStr(int opt,int n, int[][] block, String str){
        boolean flag = false;
        String[] s = str.split(",");
        int times = 1;
        for(int i=0;i<n-1;i++){
            int o1 = Integer.parseInt(s[i]);
            int o2 = Integer.parseInt(s[i+1]);
            if(block[o2][4] != block[o1][4]){
                times++;
            }
        }
        if(times == opt){
            flag = true;
        }
        else if(times < time){
            time = times;
            ssss = str;
        }
        System.out.println(times);
        return flag;
    }
}
