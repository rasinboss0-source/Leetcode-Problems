import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {

        queue.add(x);

        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
