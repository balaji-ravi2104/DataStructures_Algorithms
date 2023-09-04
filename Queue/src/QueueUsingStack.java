import java.util.Stack;

class MyQueue{
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int front;
    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int data){
        if(stack1.isEmpty()){
            front = data;
        }
        stack1.push(data);
    }

    public int pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek(){
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return front;
    }

    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(11);
        myQueue.push(12);
        myQueue.push(13);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        myQueue.push(14);
        myQueue.push(15);
        System.out.println(myQueue.pop());
        myQueue.push(16);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.push(17);

    }
}
