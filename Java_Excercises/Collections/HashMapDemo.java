import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        System.out.println("---- HashMap Operations ----");

        HashMap<Integer, String> students = new HashMap<>();

        // 1. put()
        students.put(101, "Loki");
        students.put(102, "Ujitha");
        students.put(103, "Hari");
        students.put(104, "Praveen");

        System.out.println("Initial Map: " + students);

        // 2. get()
        System.out.println("Student with roll no 102: " + students.get(102));

        // 3. containsKey()
        System.out.println("Contains key 101? " + students.containsKey(101));

        // 4. containsValue()
        System.out.println("Contains value 'Hari'? " + students.containsValue("Hari"));

        // 5. remove()
        students.remove(103);
        System.out.println("After removing roll no 103: " + students);

        // 6. replace()
        students.replace(104, "Santhosh");
        System.out.println("After replacing 104 value: " + students);

        // 7. size()
        System.out.println("Size of map: " + students.size());

        // 8. isEmpty()
        System.out.println("Is map empty? " + students.isEmpty());

        // 9. Traversing using entrySet()
        System.out.println("\nTraversing using entrySet:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " → Name: " + entry.getValue());
        }

        // 10. Traversing only keys
        System.out.println("\nTraversing only keys:");
        for (Integer key : students.keySet()) {
            System.out.println(key);
        }

        // 11. Traversing only values
        System.out.println("\nTraversing only values:");
        for (String value : students.values()) {
            System.out.println(value);
        }

        // 12. clear()
        students.clear();
        System.out.println("\nAfter clear(): " + students);

        // 13. isEmpty after clear
        System.out.println("Is map empty now? " + students.isEmpty());
    }
}
