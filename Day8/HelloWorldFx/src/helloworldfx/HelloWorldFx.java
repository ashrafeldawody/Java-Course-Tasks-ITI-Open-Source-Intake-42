/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package helloworldfx;

import static java.awt.Color.red;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ashra
 */
public class HelloWorldFx extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text helloText = new Text("Hello World");
        helloText.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
helloText.setFill(Color.RED);

        helloText.setEffect(new Reflection());


        StackPane root = new StackPane();
        root.getChildren().add(helloText);
        Scene scene = new Scene(root, 300, 250);


        Stop[] stops = new Stop[] {
            new Stop(0, Color.BLACK),
            new Stop(1, Color.WHITE),
        };

        scene.setFill(new LinearGradient(50, 50, 50, 130, false, CycleMethod.REFLECT, stops));

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
