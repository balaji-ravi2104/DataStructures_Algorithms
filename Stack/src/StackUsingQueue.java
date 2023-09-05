import java.util.LinkedList;
import java.util.Queue;

class MyStack{
    Queue<Integer> queue;

    public MyStack(){
        queue = new LinkedList<>();
    }

    public void push(int data){
        queue.add(data);
        for(int i=1;i<queue.size();i++){
            queue.offer(queue.remove());
        }
    }

    public int pop(){
        return queue.remove();
    }

    public int peek(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        System.out.println(myStack.pop());
        myStack.push(14);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.push(15);
        myStack.push(16);
        myStack.push(17);
        System.out.println(myStack.peek());
        System.out.println(myStack.empty());
    }
}
