package HomeworkCollections;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String, Record> phoneBook = new HashMap<>();

    public void add(String surname, String phone){
        if (phoneBook.containsKey(surname)){
            Record record =  phoneBook.get(surname);
            record.add(phone);
        } else {
            Record record = new Record(surname);
            record.add(phone);
            phoneBook.put(surname, record);
        }
    }

    public ArrayList<String> get(String surname){
        return phoneBook.get(surname).getPhones();
    }
}
