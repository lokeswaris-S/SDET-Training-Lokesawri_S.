import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        
        System.out.println("---- ArrayList ----");
        
        ArrayList<String> list = new ArrayList<>();

        // 1. add()
        list.add("Loki");
        list.add("Praveen");
        list.add("Hari");
        list.add("Param");
        list.add("Santhosh");
        list.add("Ujitha");
        list.add("Abhijit");

        System.out.println("ArrayList: " + list);

        // 2. remove(Object)
        list.remove("Hari");
        System.out.println("After removal: " + list);

        // 3. contains()
        System.out.println("Contains 'Loki'? " + list.contains("Loki"));

        // 4. sort()
        java.util.Collections.sort(list);
        System.out.println("After sorting: " + list);

        // 5. get()
        System.out.println("Element at index 2: " + list.get(2));

        // 6. set()
        list.set(1, "Rahul");
        System.out.println("After updating index 1: " + list);

        // 7. size()
        System.out.println("Size of ArrayList: " + list.size());

        // 8. indexOf()
        System.out.println("Index of Loki: " + list.indexOf("Loki"));

        // 9. isEmpty()
        System.out.println("Is list empty? " + list.isEmpty());

        // 10. add at specific index
        list.add(2, "Kiran");
        System.out.println("After inserting at index 2: " + list);

        // 11. remove by index
        list.remove(3);
        System.out.println("After removing index 3: " + list);

        // 12. clear()
        list.clear();
        System.out.println("After clear(): " + list);

        // 13. isEmpty after clear
        System.out.println("Is list empty now? " + list.isEmpty());
    }
}
