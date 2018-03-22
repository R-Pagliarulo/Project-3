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
import javafx.animation.*;
import java.util.Random;
import javafx.scene.text.*;

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
    
    for(int a=0;a<2;a++){
      
      double b = 200*a;
      
      Car carAI = new Car("car","RED");//creates car to use the random speed and random path methods
      
      Polygon car = new Polygon();//creates the shapes that look like cars
      car.getPoints().addAll(new Double[]{
        50.0, 150.0+b,
        100.0, 150.0+b,
        120.0, 160.0+b,
        120.0, 170.0+b,
        100.0, 180.0+b,
        50.0, 180.0+b,
        50.0, 150.0+b,
    });
      car.setFill(Color.RED);//makes the 'cars' red
      
      Rectangle road = new Rectangle();//creates rectangle that looks like a road the cars are driving on
      road.setX(30);
      road.setY(110+b);
      road.setWidth(1100);
      road.setHeight(100);
      road.setArcWidth(20);
      road.setArcHeight(20);
      road.setFill(Color.GREY);
      
      Text ta = new Text();
      ta.setText("A");//Creates the A text
      if(carAI.firstStop() == 'A'){//checks if A should be at the first stop
        ta.setX(250);
        ta.setY(100+b);
      }
      else if(carAI.secondStop() == 'A'){//checks if A should be at the second stop
        ta.setX(500);
        ta.setY(100+b);
      }
      else if(carAI.thirdStop() == 'A'){//checks if A should be at the third stop
        ta.setX(750);
        ta.setY(100+b);
      }
      else if(carAI.fourthStop() == 'A'){//checks if A should be at the fourth stop
        ta.setX(1000);
        ta.setY(100+b);
      }
      
      
      Text tb = new Text();
      tb.setText("B");
      if(carAI.firstStop() == 'B'){//checks if B should be at the first stop
        tb.setX(250);
        tb.setY(100+b);
      }
      else if(carAI.secondStop() == 'B'){//checks if B should be at the second stop
        tb.setX(500);
        tb.setY(100+b);
      }
      else if(carAI.thirdStop() == 'B'){//checks if B should be at the third stop
        tb.setX(750);
        tb.setY(100+b);
      }
      else if(carAI.fourthStop() == 'B'){//checks if B should be at the fourth stop
        tb.setX(1000);
        tb.setY(100+b);
      }
      
      
      Text tc = new Text();
      tc.setText("C");
      if(carAI.firstStop() == 'C'){//checks if C should be at the fourth stop
        tc.setX(250);
        tc.setY(100+b);
      }
      else if(carAI.secondStop() == 'C'){//checks if C should be at the fourth stop
        tc.setX(500);
        tc.setY(100+b);
      }
      else if(carAI.thirdStop() == 'C'){//checks if C should be at the fourth stop
        tc.setX(750);
        tc.setY(100+b);
      }
      else if(carAI.fourthStop() == 'C'){//checks if C should be at the fourth stop
        tc.setX(1000);
        tc.setY(100+b);
      }
      
      
      Text td = new Text();
      td.setText("D");
      if(carAI.firstStop() == 'D'){//checks if D should be at the fourth stop
        td.setX(250);
        td.setY(100+b);
      }
      else if(carAI.secondStop() == 'D'){//checks if D should be at the fourth stop
        td.setX(500);
        td.setY(100+b);
      }
      else if(carAI.thirdStop() == 'D'){//checks if D should be at the fourth stop
        td.setX(750);
        td.setY(100+b);
      }
      else if(carAI.fourthStop() == 'D'){//checks if D should be at the fourth stop
        td.setX(1000);
        td.setY(100+b);
      }
      
      TranslateTransition transitiona1 = new TranslateTransition();//sets movement for car
      transitiona1.setToX(1000);
      transitiona1.setDuration(Duration.seconds(10-carAI.getSpeed()));
      transitiona1.setNode(car);
      transitiona1.play();
        
      
      root.getChildren().addAll(road,car,ta,tb,tc,td);//adds the nodes into the Pane
     }
    Scene scene = new Scene(root, 1200, 800);//creates the scene that will be returned to the start method
    return scene;
  }
}
