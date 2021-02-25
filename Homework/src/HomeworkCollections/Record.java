package HomeworkCollections;

import java.util.ArrayList;

public class Record {
    private String surname;

    private ArrayList<String> phones = new ArrayList<>();

    public Record(String surname) {
        this.surname = surname;
    }

    public void add(String phone){
        this.phones.add(phone);
    }

    public ArrayList<String> getPhones() {
        return phones;
    }
}
