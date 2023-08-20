import java.util.*;

public class SinglyLinkedList {
    static ListNode head,tail;
    public static void InsertAtEnd(int val){
        ListNode node = new ListNode(val);
        if(head==null){
            head=tail=node;
        }else{
            // if tail is not used then use below commented code
            // Node temp = head;
            // while (temp.next != null) {
            //     temp = temp.next;
            // }
            // temp.next = nn;
            tail.next=node;
            tail=node;
        }
    }

    public static void InsertAtBeginning(int val){
        ListNode node = new ListNode(val);
        if (head != null) {
            node.next = head;
        }
        head=node;
    }

    public static void InsertAtParticularPosition(int val,int pos){
        ListNode node = new ListNode(val);
        ListNode temp = head;
        int count=1;
        if(pos==1){
            node.next = head;
            head = node;
        }else{
            while(temp!=null && count<pos-1){
                count++;
                temp = temp.next;
            }
            if(temp==null){
                System.out.println("Invalid Position");
                return;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    public static void DeleteAtBeginning(){
        if(head!=null){
            head = head.next;
        }else{
            System.out.println("List is Empty!!");
        }
    }

    public static void DeleteAtEnd(){
        if(head==null){
            System.out.println("List is Empty!!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        ListNode temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void DeleteAtParticularPosition(int pos){
        if(head==null){
            System.out.println("List is Empty!!");
            return;
        }
        if(pos==1){
            head=null;
            return;
        }
        int count = 1;
        ListNode temp = head;
        while(count < pos-1){
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public static void ReverseIterative(){
        ListNode Next;
        ListNode Prev=null;
        while (head!=null){
            Next = head.next;
            head.next = Prev;
            Prev = head;
            head = Next;
        }
        head = Prev;
    }

    public static ListNode reverseRecursive(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static  void reverseInBlockOfSizeK(int k) {
        head = reverseInBlock(head, k);
    }

    private static ListNode reverseInBlock(ListNode node, int k) {
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        // Count the number of nodes in the current block
        ListNode temp = current;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        // Reverse the first K nodes of the current block
        if (count == k) {
            while (count > 0 && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count--;
            }

            // Recursively reverse the remaining blocks
            if (next != null) {
                node.next = reverseInBlock(next, k);
            }

            return prev;
        } else {
            // If there are fewer than K nodes in the current block, do not reverse
            return current;
        }
    }

    public static void Display(ListNode head){
        while (head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,pos;
        while(true) {
            System.out.println("Enter your choice");
            System.out.println("1.InsertAtEnd \n2.InsertAtBeginning \n3.InsertAtParticularPosition \n4.DeleteAtBeginning \n5.DeleteAtEnd \n6.DeleteAtParticularPosition \n7.ReverseIterative \n8.reverseRecursive\n9.reverseInBlockOfSizeK\n10.Display\n11.Exit");
            int num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("Enter the Number");
                    n = sc.nextInt();
                    InsertAtEnd(n);
                }
                case 2 -> {
                    System.out.println("Enter the Number");
                    n = sc.nextInt();
                    InsertAtBeginning(n);
                }
                case 3 -> {
                    System.out.println("Enter the Number");
                    n = sc.nextInt();
                    System.out.println("Enter the Position");
                    pos = sc.nextInt();
                    InsertAtParticularPosition(n, pos);
                }
                case 4 -> DeleteAtBeginning();
                case 5 -> DeleteAtEnd();
                case 6 -> {
                    System.out.println("Enter the Position to delete");
                    pos = sc.nextInt();
                    DeleteAtParticularPosition(pos);
                }
                case 7 -> ReverseIterative();
                case 8 -> {
                    head = reverseRecursive(head);
                }
                case 9 -> {
                    System.out.println("Enter the value of K");
                    int k = sc.nextInt();
                    reverseInBlockOfSizeK(k);
                }
                case 10 -> Display(head);
                case 11 -> System.exit(0);
                default -> System.out.println("Please Enter the Correct Choice");
            }
        }
    }
}
