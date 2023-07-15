package nursery.accounting.system;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Sit, Fetch", "2020-01-15");
        Cat cat = new Cat("Whiskers", "Meow, Purr", "2019-05-02");
        Hamster hamster = new Hamster("Nibbles", "Run on Wheel", "2022-03-10");
        Horse horse = new Horse("Spirit", "Gallop, Trot", "2018-09-20");
        Camel camel = new Camel("Sandy", "Carry Load", "2021-11-05");
        Donkey donkey = new Donkey("Eeyore", "Carry Load", "2020-07-30");

        System.out.println("Dog: " + dog.getName() + ", Commands: " + dog.getCommands() + ", Birth Date: " + dog.getBirthDate());
        System.out.println("Cat: " + cat.getName() + ", Commands: " + cat.getCommands() + ", Birth Date: " + cat.getBirthDate());
        System.out.println("Hamster: " + hamster.getName() + ", Commands: " + hamster.getCommands() + ", Birth Date: " + hamster.getBirthDate());
        System.out.println("Horse: " + horse.getName() + ", Commands: " + horse.getCommands() + ", Birth Date: " + horse.getBirthDate());
        System.out.println("Camel: " + camel.getName() + ", Commands: " + camel.getCommands() + ", Birth Date: " + camel.getBirthDate());
        System.out.println("Donkey: " + donkey.getName() + ", Commands: " + donkey.getCommands() + ", Birth Date: " + donkey.getBirthDate());
    }
}
