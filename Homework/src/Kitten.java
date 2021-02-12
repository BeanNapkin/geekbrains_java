public class Kitten {

    private final String name;
    private final int appetite;
    private boolean isNotHungry;

    public Kitten(String name, int appetite, boolean isNotHungry) {
        this.name = name;
        this.appetite = appetite;
        this.isNotHungry = isNotHungry;
    }

    public void setIsNotHungry(boolean notHungry) {
        isNotHungry = notHungry;
    }

    public boolean getIsNotHungry() {
        return isNotHungry;
    }

    public String getName() {
        return name;
    }

    public boolean eat(Plate plate) {
        if (plate.isEnoughFood(appetite)) {
            plate.decreaseFood(appetite);
            setIsNotHungry(true);
            System.out.println(getName() + " съел " + appetite + " еды.");
            return true;
        } else {
            return false;
        }
    }
}
