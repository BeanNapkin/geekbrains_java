package Homework8;

public class RunningTrack {

    public final int length = 1000;

    public int getLength() {
        return length;
    }

    public boolean run(Running running){
        return running.getLength() >= this.length;
    }
}
