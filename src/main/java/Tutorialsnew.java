
public class Tutorialsnew {


public void myMethod()   
{  
System.out.println("Method");  
}  
  
{  
System.out.println(" Instance Block");  
}  
      
public void Tutorialsnew()  
{  
System.out.println("Constructor ");  
}  
static {  
    System.out.println("static block");  
}  
public static void main(String[] args) {  
	Tutorialsnew c = new Tutorialsnew();  
c.Tutorialsnew();  
c.myMethod();  
}  
}   

