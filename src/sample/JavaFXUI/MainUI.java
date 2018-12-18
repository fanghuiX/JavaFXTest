package sample.JavaFXUI;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import sample.DemoTest.Input;
import sample.SortCompare.SortCompare;
import sample.inputTree.Defaultui;
import sample.inputTree.Inputbtree;
import sample.inputTree.Searchtree;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUI implements Initializable {
    @FXML
    private ChoiceBox choicetree,choicegraph,choicesort,choiceg;
    public static int index;
    public static int graphindex;
    public static int sortindex;
    public static int gindex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //响应ChoiceBox：choicetree的选择
        choicetree.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicetree index:"+new_val);
                    index = new_val.intValue();
                    if(new_val.intValue() != 0) {
                        if (new_val.intValue() != 3) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Inputbtree.getInstance().start(new Stage());
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            });
                        } else {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Searchtree.getInstance().start(new Stage());
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            });
                        }
                    }
                }
        );
        //响应ChoiceBox：choicegraph的选择
        choicegraph.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicegraph index:"+new_val);
                    graphindex = new_val.intValue();
                    Defaultui dui = new Defaultui();
                    try{
                        dui.start(new Stage());
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
        );
        //响应ChoiceBox：choicesort的选择
        choicesort.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicesort index:"+new_val);
                    sortindex = new_val.intValue();
                    //八大排序
                    if(sortindex != 0 && sortindex != 9) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Input i = new Input();
                                    i.start(new Stage());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
                    }
                    //转入比较排序的界面
                    else if(sortindex == 9){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    SortCompare sc = new SortCompare();
                                    sc.start(new Stage());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
                    }
                }
        );
        //响应ChoiceBox：choiceg的选择
        choiceg.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choiceg index:"+new_val);
                    gindex = new_val.intValue();
                    Defaultui dui = new Defaultui();
                    try{
                        dui.start(new Stage());
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
        );
    }

}
