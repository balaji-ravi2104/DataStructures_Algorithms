import java.util.*;

public class DoublyLinkedList {
    static  ListNode head,tail;
    public static void InsertAtEnd(int val){
        ListNode node = new ListNode(val);
        if(head==null){
            head=tail=node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail =node;
        }
//        ListNode ptr=head;
//        while(ptr.next!=null){
//            ptr = ptr.next;
//        }
//        ptr.next=node;
//        node.prev=ptr;
    }

    public static void InsertAtBeginning(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head=tail=node;
        }else{
            node.next=head;
            head.prev = node;
            head = node;
        }
    }

    public static void InsertAtParticularPosition(int val,int pos){
        ListNode node = new ListNode(val);
        if(pos==1){
            node.next = head;
            if(head!=null){
                head.prev = node;
            }
            head = node;
        }else{
            int count = 1;
            ListNode temp = head;
            while(temp!=null && count < pos-1){
                count++;
                temp = temp.next;
            }
            if(temp==null){
                System.out.println("Position is out of Bound!!");
                return;
            }
            node.next = temp.next;
            node.prev = temp;
            if(temp.next!=null){
                temp.next.prev = node;
            }
            temp.next = node;
        }
    }

    public static void DeleteAtBeginning(){
        if(head==null){
            System.out.println("Head is null!! Deletion is not possible!!");
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    public static void DeleteAtEnd(){
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if(head.next==null){
            head=null;
            return;
        }
//        By Using tail pointer
//        tail = tail.prev;
//        tail.next = null;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
    }

    public static void DeleteAtParticularPosition(int pos){
        if(head==null){
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if(pos==1){
            head = head.next;
            if(head!=null){
                head.prev = null;
            }
            return;
        }
        int count = 1;
        ListNode temp = head;
        while (temp!=null && count < pos){
            temp = temp.next;
            count++;
        }
        if(temp==null){
            System.out.println("Position out of bounds.");
            return;
        }

        if(temp.next!=null){
            temp.next.prev = temp.prev;
        }

        if(temp.prev!=null){
            temp.prev.next = temp.next;
        }

    }

    public static void ReverseIterative(){
        ListNode current = head;
        ListNode temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public static ListNode reverseRecursive(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;

        return newHead;
    }
    public static void reverseInBlockOfSizeK(int k){
        head = reverseInBlockOfSizeKUtil(head, k);
    }

    public static ListNode reverseInBlockOfSizeKUtil(ListNode current,int k){
        ListNode prev = null;
        ListNode next = null;
        ListNode temp = current;
        int count = 0;

        // Reverse the first K nodes of the sublist
        while (temp != null && count < k) {
            next = temp.next;
            temp.next = prev;
            temp.prev = next;
            prev = temp;
            temp = next;
            count++;
        }

        // Connect the reversed sublist with the remaining list
        if (next != null) {
            current.next = reverseInBlockOfSizeKUtil(next, k);
            current.next.prev = current;
        }

        return prev;
    }
    public static void Display(ListNode head){
        while(head!=null){
            System.out.print(head.data+"<->");
            head = head.next;
        }
        System.out.println("null");
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
