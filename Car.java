import java.util.Random;

public class Car{
  
  private int speed;
  private String name;
  private String color;
  
  public Car(){
    speed = 0;
    name = "";
    color = "";
  }
  
  public Car(String name, String color){
    randomSpeed();
  }
  
  public String getColor(){
    return color;
  }
  
  public String getName(){
    return name;
  }
  
  public int getSpeed(){
    return speed;
  }
  
  public void setColor(String a){
    color = a;
  }
  
  public void setName(String a){
    name = a;
  }
  
  public void setSpeed(int a){
    speed = a;
  }
  
  public void randomSpeed(){
    Random rand = new Random();
    int newSpeed = rand.nextInt(5) + 1;
    speed = newSpeed;
  }
}

    