package lesson3.hw;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    HashMap<String , HashSet< String>> phoneBook = new HashMap<>();

    public void add(String  name, String phone) {

        HashSet<String> num = phoneBook.get(name);

        if (num != null) {
            num.add(phone);
        } else {
            num = new HashSet<>();
            num.add(phone);
            phoneBook.put(name, num);
        }
    }

    public void get(String name) {
        System.out.printf("Name: %s phone: %s\n", name, phoneBook.get(name));
    }
}