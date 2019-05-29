package tests;

//Java program to create a menu bar and add 
//menu to it and also add menuitems to menu 
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.control.Alert.AlertType; 
import java.time.LocalDate; 

public class MenuSample extends Application { 

 // launch the application 
 public void start(Stage s) 
 { 
     // set title for the stage 
     s.setTitle("creating MenuBar"); 

     // create a menu 
     Menu m = new Menu("Menu"); 

     // create menuitems 
     MenuItem m1 = new MenuItem("menu item 1"); 
     MenuItem m2 = new MenuItem("menu item 2"); 
     MenuItem m3 = new MenuItem("menu item 3"); 

     // add menu items to menu 
     m.getItems().add(m1); 
     m.getItems().add(m2); 
     m.getItems().add(m3); 

     // create a menubar 
     MenuBar mb = new MenuBar(); 

     // add menu to menubar 
     mb.getMenus().add(m); 

     // create a VBox 
     VBox vb = new VBox(mb); 

     // create a scene 
     Scene sc = new Scene(vb, 500, 300); 

     // set the scene 
     s.setScene(sc); 

     s.show(); 
 } 

 public static void main(String args[]) 
 { 
     // launch the application 
     launch(args); 
 } 
} 