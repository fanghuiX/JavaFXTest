package sample.JavaFXUI;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class showImage{

    public void start(Stage primaryStage) {
        ImageView imv = new ImageView();
        //错误写法，因为会预加载好图片，不会显示出处理后得到的图片，所以只会显示上一次得到的结果 
        //Image image2 = new Image(showImage.class.getResourceAsStream("out.png"));
        File out = new File("src/sample/JavaFXUI/out.png");
        String image = out.getAbsolutePath().replace('\\','/');
        Image image2 = new Image("file:"+image);
        double height = image2.getHeight();
        double width = image2.getWidth();
        primaryStage.setTitle("可视化");
        Group root = new Group();
        Scene scene = new Scene(root, width+30, height+40, Color.WHITE);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        imv.setImage(image2);

        HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(imv);
        gridpane.add(pictureRegion, 1, 1);

        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}