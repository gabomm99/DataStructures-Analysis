package a4;

public class Main {

    public static void main(String[] args) {
        Queue priority_queue = new PriorityQueue();
        priority_queue.enqueue(4.2, 1.2);
        priority_queue.enqueue(4.2, 2.2);
        priority_queue.enqueue(6.2, 4.2);
        priority_queue.enqueue(5.2, 3.2);
        priority_queue.enqueue(1.2, 0.8);
        priority_queue.enqueue(8.1, 10.2);
        priority_queue.enqueue(0.6, 0.7);
        priority_queue.enqueue(10.2, 90.2);
        priority_queue.enqueue(7.2, 7.2);
        priority_queue.enqueue(2.2, 0.85);
        priority_queue.enqueue(9.2, 18.7);
        priority_queue.enqueue(0.5, 0.7);
        priority_queue.sort();

    }
}
