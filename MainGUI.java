/**
 * @author Paul MacAllister
 * @author Nathan Staley
 * @author Robert Pagliarulo
 * @since 03-22-2018
 * 
 * Software Design
 * Prof Moussavi
 * Project 3
 * 
 * This class creates a GUI which has 2 shapes representing cars, 2 big grey squares representing the asphalt they're 
 * driving on, locations in which they drive to(which are labeled by a letter and smaller and different colored square),
 * a start button, and two reset buttons.
 * 
 * This class takes the two car shapes and has each of them "drive" to all four locations in a random order, at a random speed,
 * the random order is labeled above each car, and the whole process is started by pressing the start button, and reset with
 * the reset button.
 * 
 */
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
  
  public int startEnable = 0;//used to set when the start button will be enabled or not
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Transition");//title of program
    primaryStage.setResizable(false);//making the program bigger makes it look goofy
    primaryStage.setScene(makeGUI());//creates the scene
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
      start.setDisable(true);//diables the button after it is clicked so it does not create multiple instances of the simulation
      startEnable = 0;
      for(int a=0;a<2;a++){
        
        double checkx = 600*a;//used help place where the buttons and cars will be in the GUI
      
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
        
        
        
        Text pathlabel = new Text("Car 1 Path: " + carAI.getPath());//creates a label that shows the path for each car, and puts it above each car
        pathlabel.setX(10+checkx);//places where the label(s) will be
        pathlabel.setY(100);
        
        Button reset = new Button("");//names the button based on which car is being created
        if(a==0)
          reset.setText("Reset Simulation: Car1");
        else
          reset.setText("Reset Simulation: Car2");
        reset.setOnAction(new EventHandler<ActionEvent>(){
          @Override public void handle(ActionEvent e){
            startEnable += 1;//when a reset button is pressed, it uses this to make sure that the start button is enabled only after
            if(startEnable == 2)//both reset buttons have been pressed
              start.setDisable(false);
          root.getChildren().remove(car);//removed the car, reset button, and pathlabel after the reset button is pressed 
          root.getChildren().remove(reset);
          root.getChildren().remove(pathlabel);
        }
      });
        
      reset.setLayoutX(10+checkx);//places where the reset button will be (+600x for the second)
      reset.setLayoutY(30);
      Path path = new Path();//Path object to put in the PathTransition object
      
      MoveTo moveTo = new MoveTo(50.0+checkx, 150.0);//sets where the cars will start
      
      path.getElements().addAll(moveTo,locArray[0],locArray[1],locArray[2],locArray[3]);//adds the locations and begining location into the path
      PathTransition movements = new PathTransition();//sets movement for car
      movements.setDuration(Duration.seconds(30-carAI.getSpeed()));//duration for how long the transition will last
      movements.setPath(path);
      movements.setNode(car);//sets the car as the object that will be moving
      movements.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);//makes the cars face the way they are moving
      movements.play();//runs the movement
      
      
      root.getChildren().addAll(reset,car,pathlabel);//adds the nodes into the Pane
     }
       
    }
});
    
    for(int a=0;a<2;a++){
      int checkx = 590*a;
      Rectangle road = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
      road.setX(10+checkx);//first rectangle set to be 10 to the right from the left side of the window
      road.setY(110);
      road.setWidth(550);
      road.setHeight(500);
      road.setArcWidth(20);
      road.setArcHeight(20);
      road.setFill(Color.GREY);
      root.getChildren().add(road);//adds the 2 "roads"
    }
    
    for(int a=0;a<2;a++){//for loop that creates the two sets of letters for the locations, and the locations themselves
      
      int checkx = 600*a;//used to put the second set of letters 600 to the right of the first letters
      
      Rectangle loca = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
      loca.setX(80+checkx);//first rectangle set to be 10 to the right from the left side of the window
      loca.setY(170);
      loca.setWidth(50);
      loca.setHeight(50);
      loca.setArcWidth(20);
      loca.setArcHeight(20);
      loca.setFill(Color.ORANGE);
      
      Rectangle locb = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
      locb.setX(180+checkx);//first rectangle set to be 10 to the right from the left side of the window
      locb.setY(440);
      locb.setWidth(50);
      locb.setHeight(50);
      locb.setArcWidth(20);
      locb.setArcHeight(20);
      locb.setFill(Color.ORANGE);
      
      Rectangle locc = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
      locc.setX(280+checkx);//first rectangle set to be 10 to the right from the left side of the window
      locc.setY(270);
      locc.setWidth(50);
      locc.setHeight(50);
      locc.setArcWidth(20);
      locc.setArcHeight(20);
      locc.setFill(Color.ORANGE);
      
      Rectangle locd = new Rectangle();//creates RECTANGLE that looks like a road the cars are driving on
      locd.setX(480+checkx);//first rectangle set to be 10 to the right from the left side of the window
      locd.setY(370);
      locd.setWidth(50);
      locd.setHeight(50);
      locd.setArcWidth(20);
      locd.setArcHeight(20);
      locd.setFill(Color.ORANGE);
      
      Text ta = new Text();
      ta.setText("A");//Creates the A text
      ta.setX(100+checkx);//places the A text at location A
      ta.setY(200);
     
      Text tb = new Text();
      tb.setText("B");//creates the B text
      tb.setX(200+checkx);//places the B text at location B
      tb.setY(470);
      
      Text tc = new Text();
      tc.setText("C");//creates the C text
      tc.setX(300+checkx);//places the C text at location C
      tc.setY(300);
   
      Text td = new Text();
      td.setText("D");//creates the D text
      td.setX(500+checkx);//places the D text at location D
      td.setY(400);
      
      root.getChildren().addAll(loca,locb,locc,locd,ta,tb,tc,td);//adds the texts into the Pane, this is done after the roads are added so they are visible
    }
    
    root.getChildren().add(start);
    
    Scene scene = new Scene(root, 1150, 650);//creates the scene that will be returned to the start method
    return scene;
  }
}
