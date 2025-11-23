import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    public static void main(String[] args) {

        System.out.println("------ HashSet Operations ------");

        HashSet<String> fruits = new HashSet<>();

        // 1. add() method
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Orange");  

        System.out.println("Fruits Set:" + fruits);

        // 2. contains() method
        System.out.println("Contains Mango" + fruits.contains("Mango"));

        // 3. remove() method
        fruits.remove("Banana");
        System.out.println("After removing Banana:" + fruits);

        // 4. size() method
        System.out.println("Size of set:" + fruits.size());

        // 5. isEmpty() method
        System.out.println("Is set empty" + fruits.isEmpty());

        // 6. Traversing using for-each
        System.out.println("Traversing using for-each:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 7. Traversing using Iterator
        System.out.println("Traversing using Iterator:");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 8. clear()
        fruits.clear();
        System.out.println("\nAfter clear(): " + fruits);

        // 9. isEmpty()
        System.out.println("Is set empty now? " + fruits.isEmpty());
    }
}
