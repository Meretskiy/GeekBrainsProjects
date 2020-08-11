package lesson3_Collections.test;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {

        HashMap<Integer, String> passportsAndNames = new HashMap<>();
        passportsAndNames.put(123, "One");
        passportsAndNames.put(125, "Three");
        passportsAndNames.put(124, "Two");
        passportsAndNames.put(126, "Four");
        System.out.println(passportsAndNames.get(123));
        System.out.println("----------");
        for (Map.Entry<Integer, String> hm : passportsAndNames.entrySet()) {
            System.out.println(hm.getKey() + " " + hm.getValue());
        }
        System.out.println("----------");
        System.out.println(passportsAndNames);
        System.out.println("----------");
        System.out.println(passportsAndNames.values());
        System.out.println(passportsAndNames.containsKey(126));
        System.out.println(passportsAndNames.keySet());
    }
}
