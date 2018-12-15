package sample.JavaFXUI;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import sample.DemoTest.Input;
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
    //响应ChoiceBox：choicetree的选择
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicetree.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicetree index:"+new_val);
                    index = new_val.intValue();
                    if(new_val.intValue() != 3) {
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
                    }
                    else{
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
        );

        choicegraph.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicegraph index:"+new_val);
                    graphindex = new_val.intValue();
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
        );

        choicesort.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println("choicesort index:"+new_val);
                    sortindex = new_val.intValue();
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
        );

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
