package nursery.accounting.system;

// Дочерний класс Домашние животные
public class Pet extends Animal {
    private String petType;

    public Pet(String name, String commands, String birthDate, String petType) {
        super(name, commands, birthDate);
        this.petType = petType;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public void updateCommands(String newCommands) {
        setCommands(newCommands);
    }
}
