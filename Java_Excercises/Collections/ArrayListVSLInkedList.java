import java.util.*;

public class ListComparison {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // ADD
        long start1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        long end2 = System.nanoTime();

        System.out.println("ArrayList Add Time: " + (end1 - start1));
        System.out.println("LinkedList Add Time: " + (end2 - start2));

        // SEARCH
        start1 = System.nanoTime();
        arrayList.contains(9000);
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        linkedList.contains(9000);
        end2 = System.nanoTime();

        System.out.println("ArrayList Search Time: " + (end1 - start1));
        System.out.println("LinkedList Search Time: " + (end2 - start2));

        // REMOVE
        start1 = System.nanoTime();
        arrayList.remove(5000);
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        linkedList.remove(5000);
        end2 = System.nanoTime();

        System.out.println("ArrayList Remove Time: " + (end1 - start1));
        System.out.println("LinkedList Remove Time: " + (end2 - start2));
    }
}
