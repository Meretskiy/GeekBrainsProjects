package lesson3.manual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {
        Map<Employee, String> employeeStringMap = new HashMap<>();
        employeeStringMap.put(new Employee(), "Test");
        System.out.println(employeeStringMap.toString());

        Map<String, List<Integer>> numbersOfPerson = new HashMap<>();
        numbersOfPerson.put("Maks", Arrays.asList(123123, 123123, 23));

        Map<String, Integer> phoneNumbers = new HashMap<>();
        phoneNumbers.put("Maks", 172461);
        phoneNumbers.put("Maks", 1724612323);
        phoneNumbers.put("maks", 171232461);
        phoneNumbers.put("Dima", 17241231);
        System.out.println(phoneNumbers.toString());
        System.out.println(phoneNumbers.get("maks"));
        System.out.println(phoneNumbers.get("maks123"));

        System.out.println(phoneNumbers.containsValue("maks123"));

        System.out.println(phoneNumbers.keySet());
        System.out.println(phoneNumbers.values());
        System.out.println(phoneNumbers.entrySet());

        System.out.println("====");
        System.out.println("Keys");
        for (String key : phoneNumbers.keySet()) {
            System.out.println(key);
        }
        System.out.println("====");
        System.out.println("Value");
        for (Integer val : phoneNumbers.values()) {
            System.out.println(val);
        }
        System.out.println("====");
        System.out.println("Key+Val");
        for (Map.Entry entry : phoneNumbers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
    static void doGenericDemo() {
        Collection<Integer> numbers = new HashSet();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
//        numbers.add("1");
        numbers.add(2);
        for (Object val : numbers) {
            System.out.println(Integer.parseInt(String.valueOf(val)));
        }
    }

    static void doSetDemo() {
        Set numbers = new HashSet();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        System.out.println(numbers.toString());

        Set linkedNumbers = new LinkedHashSet();
        linkedNumbers.add(23);
        linkedNumbers.add(23);
        linkedNumbers.add(23);
        linkedNumbers.add(32);

        System.out.println(linkedNumbers.toString());
    }

    static void doLinkedListDemo() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
//        System.out.println(linkedList.get(0));
        for(Object val : linkedList) {
            System.out.println(val);
        }
    }

    static void doListDemo() {
        List number = new ArrayList();
        System.out.println(number.size());
        System.out.println(number.isEmpty());

        number.add(1);
        number.add(2);
        number.add(5);
        number.add("A");

        System.out.println(number.size());
        System.out.println(number.isEmpty());

        System.out.println(number.get(2));
        System.out.println(number.toString());

        number.remove(1);
        System.out.println(number.toString());

        for (int i = 0; i < number.size(); i++) {
            Integer.parseInt(String.valueOf(number.get(i)));
        }

        List collOfColls = new ArrayList();
        collOfColls.add(new ArrayList<>());
        collOfColls.add(new ArrayList<>());
        collOfColls.add(new ArrayList<>());

        List aColl = new ArrayList();
        aColl.add(new Employee());
    }
}
