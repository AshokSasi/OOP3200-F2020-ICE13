package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT =480;
    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        //step 1 create a control
        Label ImageLabel = new Label("XBOX Series X");

        Button clickMeButton = new Button("Click me");

        //set up the path
        FileInputStream imagePath = new FileInputStream("src/sample/xboxseriesx.jpg");
        //make the image
        Image xboxseriesx = new Image(imagePath);
        //make the imageview
        ImageView consoleImageView = new ImageView(xboxseriesx);

        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);
        FileInputStream ps5Path = new FileInputStream("src/sample/ps5.jpg");
        Image ps5 = new Image(ps5Path);
       // ImageView  ps5ImageView = new ImageView(ps5);
        //step 1.2 button event
      /*  clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ImageLabel.setText("PS5!!!");
                consoleImageView.setImage(ps5);
            }
        });*/

        class ButtonClickerHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                ImageLabel.setText("PS5!!!");
                consoleImageView.setImage(ps5);

            }
        }
        clickMeButton.setOnAction(new ButtonClickerHandler());
        //step 2 create a container
        HBox hbox = new HBox(10,ImageLabel);

        HBox hbox2 =new HBox(10,consoleImageView);

        hbox.setStyle("-fx-border-color: #8b06ff; -fx-alignment: center; ");
        hbox2.setStyle("-fx-border-color: #0bf807");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox,0,0);
        gridPane.add(hbox2,0,1);
        gridPane.add(clickMeButton,2,2);
     //   gridPane.add(consoleImageView,3,3);

       // hbox.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        gridPane.setStyle("-fx-border-color: #8b06ff; -fx-font-size: 20px; -fx-font-family: 'Consolas'; " +
                "-fx-font-weight: bold; -fx-cell-size: 60px");


        // step 3 add layout container to scene
        Scene scene = new Scene(gridPane,WIDTH,HEIGHT);

        //step 4 - add scene to stage
        primaryStage.setScene(scene);
       // Scene scene = new Scene(primaryStage, WIDTH,HEIGHT);
       // primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
