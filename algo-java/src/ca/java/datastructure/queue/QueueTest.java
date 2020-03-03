package ca.java.datastructure.queue;

public class QueueTest {
    public static void main(String[] args) {
        BasicQueue<Integer> queue = new BasicQueue<>(4);
        queue.enQue(1);
        queue.enQue(2);
        queue.enQue(3);
        queue.enQue(4);
        System.out.println(queue.size());
        System.out.println(queue.access(3));
        System.out.println(queue.size());
    }
}
