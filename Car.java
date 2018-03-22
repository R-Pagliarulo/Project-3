import java.util.Random;
public class Car{
  private int speed;
  private String name;
  private String color;
  private String path;
  
  public Car(){
    speed = 0;
    name = "";
    color = "";
    path = "";
  }
  
  public String getName(){
    return name;
  }
  
  public int getSpeed(){
    return speed;
  }
  
  public void setName(String a){
    name = a;
  }
  
  public void setSpeed(int a){
    speed = a;
  }
  
  private void randomSpeed(){
    Random rand = new Random();
    int newSpeed = rand.nextInt(100) + 1;
    speed = newSpeed;
  }
  
  public void randomPath(){
    int check = 0;
    int x=0;
    Random rand = new Random();
    
    while(x<1){
      int nextLoc = rand.nextInt(4) + 1;
      if(nextLoc == 4){
        if(path.contains("D")){}
        else{
          path += "D";
          check += 1;
      }
      }
      if(nextLoc == 3){//3
        if(path.contains("C")){}
        else{
          path += "C";
          check += 1;
        }
      }
      if(nextLoc == 2){//2
        if(path.contains("B")){}
        else{
          path += "B";
          check += 1;
        }
      }
      if(nextLoc == 1){//1
        if(path.contains("A")){}
        else{
          path += "A";
          check += 1;
        }
      }
      if(check == 4)
        x=1;
    }
  }
}

    