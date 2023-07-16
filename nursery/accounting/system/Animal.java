package nursery.accounting.system;

// Родительский класс Животное
public class Animal {
    private String name;
    private String commands;
    private String birthDate;

    public Animal(String name, String commands, String birthDate) {
        this.name = name;
        this.commands = commands;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getCommands() {
        return commands;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Команды: " + commands + ", Дата рождения: " + birthDate;
    }
}

