import java.util.Scanner;

class UndoRedo{
   private final String undoStack[];
   private final String redoStack[];
   private int undoTop;
   private int redoTop;
   private String currText;
   private int capacity;
   
   public UndoRedo(int capacity){
      this.undoStack = new String[capacity];
      this.redoStack = new String[capacity];
      this.undoTop=-1;
      this.redoTop=-1;
	  this.capacity=capacity;
      this.currText="";	  
   }
   
   public void write(String text){
       
	   if(undoTop<capacity-1){
		   undoTop++;
		   undoStack[undoTop]=currText;   
	   }
	   
	  currText=currText+text+" ";
	  redoTop=-1;
   
   }
   
   public void undo(){
	  if(undoTop>=0){
		  if(redoTop<capacity-1){
			 redoTop++;
			 redoStack[redoTop]=currText;
		  }
		  currText=undoStack[undoTop];
		  undoTop--;
	   
	  }else{
		  System.out.println("Nothing to Undo");
	  }
	   
   }
   
   public void redo(){
	   
	   if(redoTop>=0){
		   if(undoTop<capacity-1){
			   undoTop++;
			   undoStack[undoTop]=currText;
		   }
		   currText=redoStack[redoTop];
		   redoTop--;
	   }else{
		   System.out.println("Nothing to redo");
	   }
   }
 
    
	public void showText(){
	   System.out.println("Current Text :"+currText);
	}
}


public class UndoRedoMain{
      public static void main(String[] args){
	     UndoRedo un = new UndoRedo(5);
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 do{
			 System.out.println("Choose: 1.write 2.undo 3.redo 4.Exit: ");
			 choice = sc.nextInt();
			 
			 switch(choice){
				 case 1:
				       System.out.println("Enter the text");
					   String text = sc.next();
					   un.write(text);
					   un.showText();
					   break;
				 case 2:
				       un.undo();
					   un.showText();
					   break;
				 case 3:
				       un.redo();
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