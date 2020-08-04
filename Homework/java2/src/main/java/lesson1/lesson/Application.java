package lesson1.lesson;

public class Application {
    public static void main(String[] args) {
        Archer archer = new Archer("Robin Hood");
        archer.move();
        archer.salute();
        Wizard wizard = new Wizard("Merlin");
        wizard.attack();
        Soldier soldier = new Soldier("Lanselot");
        soldier.move();
        soldier.salute();
        Soldier soldier2 = new Soldier("King Arthur");
        soldier2.move();

        Cleric cleric = new Cleric("Bishop");
        cleric.move();
        cleric.heal();
        cleric.salute();
    }
}
