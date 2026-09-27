
import java.util.Scanner;

class Browser{
   private final String undoStack[];
   private final String redoStack[];
   private int undoTop;
   private int redoTop;
   private String currPage;
   private int capacity;
   
   public Browser(int capacity){
      this.undoStack = new String[capacity];
      this.redoStack = new String[capacity];
      this.undoTop=-1;
      this.redoTop=-1;
	  this.capacity=capacity;
      this.currPage="homepage.com";	  
   }
   
   public void visit(String text){
       
	   if(undoTop<capacity-1){
		   undoTop++;
		   undoStack[undoTop]=currPage;   
	   }
	   
	  currPage=text;
	  redoTop=-1;
   
   }
   
   public void back(){
	  if(undoTop>=0){
		  if(redoTop<capacity-1){
			 redoTop++;
			 redoStack[redoTop]=currPage;
		  }
		  currPage=undoStack[undoTop];
		  undoTop--;
	   
	  }else{
		  System.out.println("Nothing to Undo");
	  }
	   
   }
   
   public void forward(){
	   
	   if(redoTop>=0){
		   if(undoTop<capacity-1){
			   undoTop++;
			   undoStack[undoTop]=currPage;
		   }
		   currPage=redoStack[redoTop];
		   redoTop--;
	   }else{
		   System.out.println("Nothing to redo");
	   }
   }
 
    
	public void showText(){
	   System.out.println("Current Page :"+currPage);
	}
}


public class BrowserMain{
      public static void main(String[] args){
	     Browser un = new Browser(5);
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 do{
			 System.out.println("Choose: 1.visig 2.back 3.forward 4.Exit: ");
			 choice = sc.nextInt();
			 
			 switch(choice){
				 case 1:
				       un.showText();
				       System.out.println("Enter the URL");
					   String text = sc.next();
					   un.visit(text);
					   un.showText();
					   break;
				 case 2:
				       un.back();
					   un.showText();
					   break;
				 case 3:
				       un.forward();
					   un.showText();
				       break;
				 case 4:
				       System.out.println("Good Bye ...Program terminated");
					   System.exit(0);
					   break;
				 default:
				        System.out.println("Wrong choice.... Choose 1-4");
			 }
		 }while(choice!=4);
	  }
}