package sample.MenuItemEvent.SJGJS;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Gnjs{

    //单例模式
    public static volatile Gnjs itstance;
    public Gnjs(){}
    public static Gnjs getInstance(){
        if(itstance == null){
            synchronized(Gnjs.class){
                if(itstance == null){
                    itstance = new Gnjs();
                }
            }
        }
        return itstance;
    }
    private Scene scene;
    public void start(int width, int height, Stage stage, String str, String url) {
        // create the scene
        stage.setTitle(str);
        scene = new Scene(new Browser(url),width,height, Color.web("#666970"));
        stage.setScene(scene);
        stage.show();
    }
}
class Browser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser(String url) {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        webEngine.load(url);
        //add the web view to the scene
        getChildren().add(browser);

    }
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 700;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 600;
    }
}