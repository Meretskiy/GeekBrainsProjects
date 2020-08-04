package lesson1_OOP.hw;

public class Application {
    public static void main(String[] args) {

        toStartCompetition(createParticipants(), createTrials());
    }

    public static Participant[] createParticipants() {

        Participant[] participants = {new Human("Bob"), new Human("Jon"), new Human("Ivan"),
                new Cat("Tom"), new Cat("Smile"), new Cat("Pudge"),
                new Robot("Bender"), new Robot("R2D2"), new Robot("MadCat")};
        return participants;
    }

    public static Trials[] createTrials() {

        Trials[] trials = {new Treadmill(), new Wall(), new Wall(),
                new Treadmill(), new Wall(), new Treadmill(),new Wall()};
        return trials;
    }

    public static void toStartCompetition(Participant[] participants, Trials[] trials) {
        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < trials.length; j++) {
                if (!trials[j].action(participants[i])) {
                    break;
                }
            }

            System.out.println();
        }
    }
}
