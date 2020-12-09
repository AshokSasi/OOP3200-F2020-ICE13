package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static int WIDTH = 640;
    public static int HEIGHT =480;
    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        //step 1 create a control
        Label helloLabel = new Label("Hello, World");
        Label goodbyeLabel = new Label("Good, Bye");
        Button clickMeButton = new Button("Click me");


        //step 1.1 configure controls
        Font font =  Font.font("Consolas", FontWeight.BOLD,40);
        clickMeButton.setFont(font);

        //step 1.2 button event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button clicked.");
                helloLabel.setText("Clicked!!!");
            }
        });

        //step 2 create a container
        GridPane gridPane = new GridPane();
        gridPane.add(helloLabel,1,0);
        gridPane.add(goodbyeLabel,1,1);
        gridPane.add(clickMeButton,2,2);
        //HBox hbox = new HBox(helloLabel,goodbyeLabel, clickMeButton);
        //VBox vbox = new VBox(helloLabel,goodbyeLabel, clickMeButton);



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
