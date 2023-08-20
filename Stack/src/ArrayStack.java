import java.util.Scanner;

public class ArrayStack {
    private static final int DEFAULT_CAPACITY = 10;
    public static int[] array;
    public static int top;

    public ArrayStack(){
        array = new int[DEFAULT_CAPACITY];
        top=-1;
    }
    public static void push(int num){
        if(top == DEFAULT_CAPACITY-1){
            System.out.println("Stack is OverFlow");
            return;
        }
        array[++top] = num;
    }

    public static void pop(){
        if(top==-1){
            System.out.println("Stack is UnderFlow");
            return;
        }
        System.out.println("Popped element is "+array[top]);
        top--;
    }

    public static void peek(){
        if(top==DEFAULT_CAPACITY-1){
            System.out.println("Stack is UnderFlow");
            return;
        }
        System.out.println("The Peek Element is "+array[top]);
    }

    public static void IsEmpty(){
        if(top==-1){
            System.out.println("Stack is Empty!!");
        }else{
            System.out.println("Stack is not Empty!!");
        }
    }

    public static void IsFull(){
        if(top==DEFAULT_CAPACITY-1){
            System.out.println("Stack is Full");
        }else{
            System.out.println("Stack is Not Full");
        }
    }

    public static void Display(){
        if(top==-1){
            System.out.println("Stack is Empty!!");
        }else{
            for(int i=top;i>=0;i--){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack obj = new ArrayStack();
        while(true){
            System.out.println("Enter Your Choice");
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty\n5.isFull\n6.Display\n7.Exit");
            int choice = sc.nextInt();
            int n;
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the number to Push:");
                    n = sc.nextInt();
                    push(n);
                }
                case 2 -> pop();
                case 3 -> peek();
                case 4 -> IsEmpty();
                case 5 -> IsFull();
                case 6 -> Display();
                case 7 -> System.exit(0);
                default -> System.out.println("Enter the Correct Choice!!");
            }
        }
    }
}
