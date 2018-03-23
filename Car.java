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
 * This class models a car that has various attributes for
 * use in a simulation game. Some of these attributes are
 * randomized for variety.
 * 
 */
import java.util.Random;

public class Car{
  
  private int speed;
  private String name;
  private String color;
  private String path;
  private long startTime;
  private long endTime;
  
  
  public Car(String name, String color){
    speed = randomSpeed();
    this.name = name;
    this.color = color;
    path = randomPath();
    startTime = 0;
    endTime = 0;
  }
  
  public Car(){
    //randomSpeed();
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
  public long getStartTime(){
   return startTime;
  }
  public long getEndTime() {
   return endTime;
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
  public void setStartTime(long time){
   startTime = time;
  }
  public void setEndTime(long time){
   endTime = time;
  }
  
  
  public long getRaceTime() {
   return ((endTime - startTime) / 1000);
  }
  
  
  public int randomSpeed(){
    Random rand = new Random();
    int newSpeed = rand.nextInt(5) + 1;
    //speed = newSpeed;
    return newSpeed;
  }
  
  
  //random path
  public String randomPath(){
   String p = "";
   Random r = new Random();
   while(p.length() < 4){
    int rp = r.nextInt(4);
    if(rp == 0 && !p.contains("A")){
     p += "A";
    }else if(rp == 1 && !p.contains("B")){
     p += "B";
    }else if(rp == 2 && !p.contains("C")){
     p += "C";
    }else if(rp == 3 && !p.contains("D")){
     p += "D";
    }else{
     
    }
   }
   return p;
  }
  
  
  public char firstStop(){
   return path.charAt(0);
  }
  public char secondStop(){
   return path.charAt(1);
  }
  public char thirdStop(){
   return path.charAt(2);
  }
  public char fourthStop(){
   return path.charAt(3);
  }
  
  
  public String getPath(){
   return path;
  }
}
