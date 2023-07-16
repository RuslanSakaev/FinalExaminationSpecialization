package nursery.accounting.system;

// Дочерний класс Вьючные животные
public class PackAnimal extends Animal {
    private String packAnimalType;

    public PackAnimal(String name, String commands, String birthDate, String packAnimalType) {
        super(name, commands, birthDate);
        this.packAnimalType = packAnimalType;
    }

    public String getPackAnimalType() {
        return packAnimalType;
    }

    public void setPackAnimalType(String packAnimalType) {
        this.packAnimalType = packAnimalType;
    }

    public void updateCommands(String newCommands) {
        setCommands(newCommands);
    }
}
