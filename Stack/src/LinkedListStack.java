import java.util.Scanner;

public class LinkedListStack {
    static ListNode root=null;
    public static void push(int num){
        ListNode node = new ListNode(num);
        if (root != null) {
            node.next = root;
        }
        root=node;
    }

    public static void pop(){
        ListNode temp=root;
        if(root==null){
            System.out.println("Stack is UnderFlow!!!");
        }else {
            System.out.println("Popped element "+root.data);
            root = temp.next;
        }
    }

    public static void peek(){
        if(root==null){
            System.out.println("Stack is UnderFlow!!!");
        }else{
            System.out.println("Peek element "+root.data);
        }
    }

    public static void IsEmpty(){
        if(root==null){
            System.out.println("Stack is Empty!!");
        }else{
            System.out.println("Stack is Not Empty!!");
        }
    }



    public static void Display(){
        ListNode temp = root;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Your Choice");
            System.out.println("1.Push\n2.Pop\n3.Peek\n4.isEmpty\n5.Display\n6.Exit");
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
                case 5 -> Display();
                case 6 -> System.exit(0);
                default -> System.out.println("Enter the Correct Choice!!");
            }
        }
    }
}
