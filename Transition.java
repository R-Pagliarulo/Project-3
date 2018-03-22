import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.*;
import java.util.Random;

public class Transition extends Application{
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Transition");
    primaryStage.setResizable(false);
    primaryStage.setScene(makeGUI());
    primaryStage.show();
  }
  
  private Scene makeGUI(){
    Circle a = new Circle();
    a.setFill(Color.BLUE);
    a.setRadius(30);
    a.setLayoutX(50);
    a.setLayoutY(50);
    Car car1 = new Car("car1","BLUE");
    
    Circle b = new Circle();
    b.setFill(Color.BLUE);
    b.setRadius(30);
    b.setLayoutX(50);
    b.setLayoutY(150);
    Car car2 = new Car("car2","BLUE");

    
    Circle c = new Circle();
    c.setFill(Color.BLUE);
    c.setRadius(30);
    c.setLayoutX(50);
    c.setLayoutY(250);
    Car car3 = new Car("car3","BLUE");

    
    Circle d = new Circle();
    d.setFill(Color.BLUE);
    d.setRadius(30);
    d.setLayoutX(50);
    d.setLayoutY(350);
    Car car4 = new Car("car4","BLUE");

    
    TranslateTransition transitiona1 = new TranslateTransition();
    transitiona1.setDuration(Duration.seconds(6-car1.getSpeed()));
    transitiona1.setToX(500);
    transitiona1.setNode(a);
    transitiona1.play();
    
    TranslateTransition transitiona2 = new TranslateTransition();
    transitiona2.setDuration(Duration.seconds(6-car2.getSpeed()));
    transitiona2.setToX(500);
    transitiona2.setNode(b);
    transitiona2.play();
    
    TranslateTransition transitiona3 = new TranslateTransition();
    transitiona3.setDuration(Duration.seconds(6-car3.getSpeed()));
    transitiona3.setToX(500);
    transitiona3.setNode(c);
    transitiona3.play();
    
    TranslateTransition transitiona4 = new TranslateTransition();
    transitiona4.setDuration(Duration.seconds(6-car4.getSpeed()));
    transitiona4.setToX(500);
    transitiona4.setNode(d);
    transitiona4.play();
    
    Pane root = new Pane();
    root.getChildren().addAll(a,b,c,d);
    Scene scene = new Scene(root, 600, 600);
    return scene;
  }
  public static void main(String[] args){
    //launch(args);
	  Car c = new Car("C1", "Blue");
	  System.out.println(c.getPath());
	  System.out.println(c.firstStop());
	  System.out.println(c.secondStop());
	  System.out.println(c.thirdStop());
	  System.out.println(c.fourthStop());
  }
}
