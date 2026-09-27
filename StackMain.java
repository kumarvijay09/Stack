import java.util.Scanner;

class Stack{
    private final int ARR[];
    private int top;
    private final int capacity;

    public Stack(int size){
        ARR = new int[size];
        top=-1;
        capacity = size;
    }

    public void push(int data){
          if(isFull()){
            System.out.println("Stack Overflow ..Can't Push any item. ");
            return;
        }
        ARR[++top]= data;
        System.out.println("Item "+ data + " Pushed successfully..");

    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow...Nothing to pop");
            return;
        }
        System.out.println("Item "+ARR[top]+" Popped Successfully...");
        top--;
    }

    public void peek(){
      if(top==-1){
        System.out.println("Stack is Empty");
        return;
      }
      System.out.println("Top of the stack: "+ ARR[top] + " Index:"+ top);
    }

    public boolean isEmpty(){
        return top ==-1;
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public void display(){
        if(top==-1){
            System.out.println("Stack is Empty");
        }
        System.out.println("--- Current Stack (top to bottum) ---");
        for(int i=top;i>=0;i--){
            System.out.println("|"+ARR[i]+"|"+(i==top?"<-Top":""));
        }
        System.out.println("-----------------------------------");
    }
}

public class StackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(5);
      
        while (true) { 
            System.out.print("Choose 1.PUSH 2.POP 3.PEEK 4.isEMPTY 5.isFULL 6.DISPLAY 7.EXIT: ");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.print("Enter the number to push into stack: ");
                    stack.push(sc.nextInt());
                }
                case 2 -> stack.pop();
                case 3 -> stack.peek();
                case 4 -> System.out.println("Stack is " + (stack.isEmpty() ? "" : "not ") + "Empty..");
                case 5 -> System.out.println("Stack is " + (stack.isFull() ? "" : "not ") + "Full");
                case 6 -> stack.display();
                case 7 -> {
                    System.out.println("Good Bye.. Exiting Program..");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Wrong Input! Choose number 1-7");
            }
        }
    }
}
