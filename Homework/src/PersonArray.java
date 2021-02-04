public class PersonArray {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Fateeva Rita", "Developer", "rita@mail.ru", "89779991233", 20000, 25);
        persArray[2] = new Person("Smirnov Vasya", "Cleaner", "vasya@mailbox.com", "89999999999", 10000, 19);
        persArray[3] = new Person("Bublikov Artem", "Ice-cream maker", "ice@cream.com", "89992223344", 39000, 87);
        persArray[4] = new Person("Naumova Ulia", "Star", "pushinka@rambler.ru", "892377310", 23000, 43);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].printInformation();
            }
        }
    }
}
