import java.util.Random;

public class Car{
  
  private int speed;
  private String name;
  private String color;
  private String path;
  
  public Car(String name, String color){
    speed = randomSpeed();
    this.name = name;
    this.color = color;
    path = randomPath();
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
  
  public void setColor(String a){
    color = a;
  }
  
  public void setName(String a){
    name = a;
  }
  
  public void setSpeed(int a){
    speed = a;
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
