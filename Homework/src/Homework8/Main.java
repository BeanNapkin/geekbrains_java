package Homework8;

public class Main {
    public static void main(String[] args) {

        Object[] participants = new Object[3];
        Human human = new Human(50, 1);
        participants[0] = human;

        Cat cat = new Cat(1000, 15);
        participants[1] = cat;

        Robot robot = new Robot(3000, 30);
        participants[2] = robot;

        Object[] obstacles = new Object[2];

        RunningTrack runningTrack = new RunningTrack();
        obstacles[0] = runningTrack;

        Wall wall = new Wall();
        obstacles[1] = wall;

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof RunningTrack) {
                    if (participants[i] instanceof Running) {
                        if (((RunningTrack) obstacles[j]).run(((Running) participants[i]))) {
                            System.out.println(((Running) participants[i]).getName() + " пробежал.");
                        } else {
                            System.out.println(((Running) participants[i]).getName() + " не пробежал.");
                            break;
                        }
                    }

                } else if (obstacles[j] instanceof Wall) {
                    if (participants[i] instanceof Jumping) {
                        if (((Wall) obstacles[j]).jump(((Jumping) participants[i]))) {
                            System.out.println(((Jumping) participants[i]).getName() + " перепрыгнул.");
                        } else {
                            System.out.println(((Jumping) participants[i]).getName() + " не перепрыгнул.");
                            break;
                        }
                    }
                }
            }
        }
    }
}
