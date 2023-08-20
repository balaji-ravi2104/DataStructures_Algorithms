import java.util.Scanner;

public class ArrayQueue {
    private static final int DEFAULT_CAPACITY = 5;
    private static int[] array;
    private static int front,rear;

    public ArrayQueue(){
        array = new int[DEFAULT_CAPACITY];
        front=-1;
        rear=-1;
    }

    public static void enqueue(int num){
        if(rear==DEFAULT_CAPACITY-1){
            System.out.println("Queue is OverFlow!!");
        }else{
            if(front==-1){
                front=0;
            }
            array[++rear]=num;
        }
    }

    public static void dequeue(){
        if(front==-1){
            System.out.println("Queue is UnderFlow!!");
        }else{
            System.out.println("Dequeue element is "+array[front]);
            if(front==rear){
                front=-1;
                rear=-1;
            }else{
                front++;
            }
        }
    }

    public static void peek(){
        if(front==-1){
            System.out.println("Queue is UnderFlow!!");
        }else{
            System.out.println("Peek Element is "+array[front]);
        }
    }

    public static void IsEmpty(){
        if(front==-1){
            System.out.println("Queue is Empty!!");
        }else{
            System.out.println("Queue is Not Empty!!");
        }
    }

    public static void IsFull(){
        if(rear==DEFAULT_CAPACITY-1){
            System.out.println("Queue is Full!!");
        }else{
            System.out.println("Queue is Not Full!!");
        }
    }
    public static void Display(){
        if(front==-1){
            System.out.println("Queue is UnderFlow!!!");
        }else{
            for(int i=front;i<=rear;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue obj = new ArrayQueue();
        while(true){
            System.out.println("Enter Your Choice");
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty\n5.isFull\n6.Display\n7.Exit");
            int choice = sc.nextInt();
            int n;
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the number to Enqueue:");
                    n = sc.nextInt();
                    enqueue(n);
                }
                case 2 -> dequeue();
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
