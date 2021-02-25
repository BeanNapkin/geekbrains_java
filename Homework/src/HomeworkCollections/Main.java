package HomeworkCollections;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList("Яблоко", "Апельсин", "Киви", "Арбуз", "Лимон", "Мандарин",
                "Кокос", "Папайя", "Апельсин", "Груша", "Киви", "Клубника", "Абрикос", "Ежевика", "Яблоко", "Апельсин"));
        System.out.println(countList(words));

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "7999");
        phoneBook.add("Петров", "7888");
        phoneBook.add("Иванов", "7333");

        System.out.println(phoneBook.get("Иванов"));

    }

    public static HashMap<String, Integer> countList(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            String element = list.get(i);

            if (map.containsKey(element)) {
                int count = map.get(element);
                count++;
                map.put(element, count);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }
}

