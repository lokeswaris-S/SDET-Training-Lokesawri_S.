import java.util.LinkedList;
import java.util.Queue;

public class LinkedListDemo {

    public static void main(String[] args) {

        System.out.println("------ LinkedList as Queue ------");

        Queue<String> queue = new LinkedList<>();

        // 1. add()
        queue.add("Loki");
        queue.add("Ujitha");
        queue.add("Hari");
        queue.add("Praveen");

        System.out.println("Initial Queue: " + queue);

        // 2. peek()
        System.out.println("Front element (peek): " + queue.peek());

        // 3. remove()
        System.out.println("Removed: " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        // 4. offer()
        queue.offer("Sanjana");
        System.out.println("After adding Sanjana: " + queue);

        // 5. poll()
        System.out.println("Polled element: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // 6. element()
        System.out.println("Front element using element(): " + queue.element());

        // 7. size()
        System.out.println("Size of queue: " + queue.size());

        // 8. contains()
        System.out.println("Contains Hari? " + queue.contains("Hari"));

        // 9. isEmpty()
        System.out.println("Is queue empty? " + queue.isEmpty());

        // 10. clear()
        queue.clear();
        System.out.println("After clear: " + queue);

    }
}
