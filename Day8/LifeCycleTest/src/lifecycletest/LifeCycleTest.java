/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lifecycletest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ashra
 */
public class LifeCycleTest extends Application {
    public LifeCycleTest(){
        String name = Thread.currentThread().getName();
        System.out.println("Constructor: Current Thread" + name);
    }
public void init() throws Exception{

        String name = Thread.currentThread().getName();
        System.out.println("Init: Current Thread" + name);

}
    @Override
    public void start(Stage primaryStage) {
        String name = Thread.currentThread().getName();
        System.out.println("Start Function: Current Thread" + name);

        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Life Cycle Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
public void stop () throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println("Stop Function: Current Thread" + name);
        super.stop();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
