import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import java.util.Random;
import javafx.scene.text.*;
import javafx.animation.PathTransition.OrientationType;


public class MainGUI extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Transition");
    primaryStage.setResizable(false);
    primaryStage.setScene(makeGUI());
    primaryStage.show();
  }
    public static void main(String[] args){
    Application.launch(args);
  }

public Scene makeGUI(){
  
    Pane root = new Pane();
   
    Button start = new Button("Start Simulation");//start simulation button brings the cars into the scene and beings their motions
    
    start.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
      start.setDisable(true);
      for(int a=0;a<2;a++){
        
        double checkx = 600*a;//used to make the second car appear in its square
      
        Car carAI = new Car("car","RED");//creates car to use the random speed and random path methods
      
        Polygon car = new Polygon();//creates the shapes that look like cars
        car.getPoints().addAll(new Double[]{
          50.0, 150.0,
          100.0, 150.0,
          120.0, 160.0,
          120.0, 170.0,
          100.0, 180.0,
          50.0, 180.0,
          50.0, 150.0,
      });
        
        if(a==0)
          car.setFill(Color.RED);//makes the first 'car' red
        if(a==1)
          car.setFill(Color.BLUE);//makes the second 'car' blue

        LineTo[] locArray = new LineTo[4];//creates array for the following for loop to use
        for(int arry=0;arry<4;arry++){//fills array with LineTo objects for the for loop after this one
          LineTo loc = new LineTo();
          locArray[arry] = loc;
        }
        
        for(int c=0; c<4; c++){//assigns where the Car will go based off the random path is generates, made with an array and for loop to cut down on code
          if(carAI.getPath().charAt(c) == 'A'){//checks if the current path location is A
            locArray[c].setX(100+checkx);
            locArray[c].setY(200);
          }
          else if(carAI.getPath().charAt(c) == 'B'){//checks if the current path location is B
            locArray[c].setX(200+checkx);
            locArray[c].setY(470);
          }
          else if(carAI.getPath().charAt(c) == 'C'){//checks if the current path location is C
            locArray[c].setX(300+checkx);
            locArray[c].setY(300);
          }
          else if(carAI.getPath().charAt(c) == 'D'){//checks if the current path location is D
            locArray[c].setX(500+checkx);
            locArray[c].setY(400);
          }
        }
      Button reset = new Button("");
      if(a==0)
        reset.setText("Reset Simulation: Car1");
      else
        reset.setText("Reset Simulation: Car2");
      reset.setOnAction(new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent e){
        start.setDisable(false);
        root.getChildren().remove(car);
      }
    });

      Path path = new Path();//Path object to put in the PathTransition object
      
      MoveTo moveTo = new MoveTo(50.0+checkx, 150.0);//sets where the cars will start
      
      path.getElements().addAll(moveTo,locArray[0],locArray[1],locArray[2],locArray[3]);//adds the locations and begining location into the path
      PathTransition movements = new PathTransition();//sets movement for car
      movements.setDuration(Duration.seconds(30-carAI.getSpeed()));//duration for how long the transition will last
      movements.setPath(path);
      movements.setNode(car);//sets the car as the object that will be moving
      movements.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);//makes the cars face the way they are moving
      movements.play();//runs the movement
      
      reset.setLayoutX(100+checkx);
      
      root.getChildren().addAll(reset,car);//adds the nodes into the Pane
     }
       
    }
});
      
    Rectangle road = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
    road.setX(10);//first rectangle set to be 10 to the right from the left side of the window
    road.setY(110);
    road.setWidth(550);
    road.setHeight(600);
    road.setArcWidth(20);
    road.setArcHeight(20);
    road.setFill(Color.GREY);
    
    Rectangle road2 = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
    road2.setX(600);//second rectangle is shifted to start 600 over to the right
    road2.setY(110);
    road2.setWidth(550);
    road2.setHeight(600);
    road2.setArcWidth(20);
    road2.setArcHeight(20);
    road2.setFill(Color.GREY);
      
    root.getChildren().addAll(road2,road,start);//adds the 2 "roads" and start button into the Pane object root
    
    for(int a=0;a<2;a++){//for loop that creates the two sets of letters to label the locations
      
      int checkx = 600*a;//used to put the second set of letters 600 to the right of the first letters
      
      Text ta = new Text();
      ta.setText("A");//Creates the A text
      ta.setX(100+checkx);
      ta.setY(200);
     
      Text tb = new Text();
      tb.setText("B");//creates the B text
      tb.setX(200+checkx);
      tb.setY(470);
      
      Text tc = new Text();
      tc.setText("C");//creates the C text
      tc.setX(300+checkx);
      tc.setY(300);
   
      Text td = new Text();
      td.setText("D");//creates the D text
      td.setX(500+checkx);
      td.setY(400);
      
      root.getChildren().addAll(ta,tb,tc,td);//adds the texts into the Pane, this is done after the roads are added so they are visible
    }
    
    Scene scene = new Scene(root, 1200, 800);//creates the scene that will be returned to the start method
    return scene;
  }
}
