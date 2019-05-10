package sample.GraphViz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {
    @FXML
    private ToggleGroup color;
    @FXML
    private ToggleGroup shape;
    @FXML
    private ToggleGroup filled;
    @FXML
    private ToggleGroup linecolor;
    @FXML
    private ToggleGroup head;

    bean b = new bean();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String nodecolor[][] = {{"红","red"},{"橙","orange"},{"黄","yellow"},{"绿","green"},{"蓝","lightblue"},{"靛","cyan"},{"黑","black"}};
        color.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal)
            {
                RadioButton temp=(RadioButton)newVal;
                //System.out.println(temp.getText());
                for(int i=0;i<nodecolor.length;i++){
                    if(nodecolor[i][0].equals(temp.getText())) {
                        try{
                            b.setGcolor(nodecolor[i][1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                //System.out.println(b.getGcolor());
            }
        });
        String nodeshape[][] = {{"圆","33"},{"三角形","3"},{"矩形","4"},{"五边形","5"},{"六边形","6"}};
        shape.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal)
            {
                RadioButton temp=(RadioButton)newVal;
                //System.out.println(temp.getText());
                for(int i=0;i<nodeshape.length;i++){
                    if(nodeshape[i][0].equals(temp.getText())) {
                        try{
                            b.setGsides(nodeshape[i][1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                //System.out.println(b.getGsides());
            }
        });
        String nodefilled[][] = {{"是","filled"},{"否","rounded"}};
        filled.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal)
            {
                RadioButton temp=(RadioButton)newVal;
                //System.out.println(temp.getText());
                for(int i=0;i<nodefilled.length;i++){
                    if(nodefilled[i][0].equals(temp.getText())) {
                        try{
                            b.setGstyle(nodefilled[i][1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                //System.out.println(b.getGstyle());
            }
        });
        String nodelinecolor[][] = {{"黑","black"},{"红","red"},{"黄","yellow"},{"蓝","lightblue"},{"青","cyan"}};
        linecolor.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal)
            {
                RadioButton temp=(RadioButton)newVal;
                //System.out.println(temp.getText());
                for(int i=0;i<nodelinecolor.length;i++){
                    if(nodelinecolor[i][0].equals(temp.getText())) {
                        try{
                            b.setGlightcolor(nodelinecolor[i][1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                //System.out.println(b.getGlightcolor());
            }
        });
        String nodelinehead[][] = {{"无箭头","none"},{"单向箭头","forward"},{"双向箭头","both"}};
        head.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldVal, Toggle newVal)
            {
                RadioButton temp=(RadioButton)newVal;
                //System.out.println(temp.getText());
                for(int i=0;i<nodelinehead.length;i++){
                    if(nodelinehead[i][0].equals(temp.getText())) {
                        try{
                            b.setGhead(nodelinehead[i][1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                //System.out.println(b.getGhead());
            }
        });
    }

    public void click() {

    }
}
