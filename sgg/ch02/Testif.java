
import java.util.Scanner;

class Testif{
  
  public static void main(String [] args){
    
    //int age=10;
    
    Scanner scanner =  new Scanner(System.in);
    int i;
    System.out.print("i= ");
    i = scanner.nextInt();
    System.out.println("your input i :"+i);
    
    /*
    int age=10;
    if (age>10) {
      System.out.println("ok");
    } else if(age>15) {
      System.out.println("error");
    } else {
      System.out.println("error1");
    } 
    */
    
    switch(i) {
       case (10): {System.out.println("ok10");break;}
       case (11): {System.out.println("ok11");};break;
       default:   {System.out.println("default");break;}
    }
    

  }


}
