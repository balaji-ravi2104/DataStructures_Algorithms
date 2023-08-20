import java.util.Scanner;

public class LinkedListQueue {
    static ListNode front =null,rear=null;
    public static void enqueue(int num){
        ListNode node = new ListNode(num);
        if(front==null){
            front=node;
        }else{
            rear.next=node;
        }
        rear=node;
    }

    public static void dequeue(){
        ListNode temp = front;
        if(front==null){
            System.out.println("Queue is UnderFlow!!!");
        }else{
            System.out.println("Dequeue Element is "+front.data);
            front = temp.next;
        }
    }

    public static void peek(){
        if(front==null){
            System.out.println("Queue is UnderFlow!!!");
        }else{
            System.out.println("Peek Element is "+front.data);
        }
    }

    public static void IsEmpty(){
        if(front==null){
            System.out.println("Queue is Empty!!");
        }else{
            System.out.println("Queue is Not Empty!!");
        }
    }

    public static void Display(){
        ListNode temp = front;
        if(front==null){
            System.out.println("Queue is UnderFlow!!!");
        }else{
            while (temp!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Your Choice");
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty\n5.Display\n6.Exit");
            int choice = sc.nextInt();
            int n;
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the number to Enqueue: ");
                    n = sc.nextInt();
                    enqueue(n);
                }
                case 2 -> dequeue();
                case 3 -> peek();
                case 4 -> IsEmpty();
                case 5 -> Display();
                case 6 -> System.exit(0);
                default -> System.out.println("Enter the Correct Choice!!");
            }
        }
    }
}
