/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package helloworldfxcss;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ashra
 */
public class HelloWorldFxCss extends Application {
    @Override
    public void start(Stage primaryStage) {

        Text helloText = new Text("Hello World");
        helloText.setEffect(new Reflection());
        helloText.getStyleClass().add("text");
        StackPane root = new StackPane();
        root.getChildren().add(helloText);
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("css.css").toString());


        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
