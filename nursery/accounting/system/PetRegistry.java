package nursery.accounting.system;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetRegistry {
    private List<Animal> animals;
    private Counter counter;
    

    public PetRegistry() {
        animals = new ArrayList<>();
        counter = new Counter();
    }

    public void addAnimal(Animal animal) throws Exception {
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;
            if (pet.getName() == null || pet.getCommands() == null || pet.getBirthDate() == null || pet.getPetType() == null) {
                throw new IllegalArgumentException("Недостаточно данных для добавления нового питомца.");
            }
        } else if (animal instanceof PackAnimal) {
            PackAnimal packAnimal = (PackAnimal) animal;
            if (packAnimal.getName() == null || packAnimal.getCommands() == null || packAnimal.getBirthDate() == null || packAnimal.getPackAnimalType() == null) {
                throw new IllegalArgumentException("Недостаточно данных для добавления нового животного.");
            }
        }
        animals.add(animal);
        counter.add();
    }

    public void displayAnimalCommands(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                System.out.println("Вид животного: " + getAnimalType(animal));
                System.out.println("Команды для " + animal.getName() + ": " + animal.getCommands());
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    public void teachAnimalCommands(String animalName, String newCommands) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                animal.setCommands(newCommands);
                System.out.println("Команды для " + animal.getName() + " были обновлены.");
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private String getAnimalType(Animal animal) {
        if (animal instanceof Pet) {
            return ((Pet) animal).getPetType();
        } else if (animal instanceof PackAnimal) {
            return ((PackAnimal) animal).getPackAnimalType();
        } else {
            return "Неизвестный тип";
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Посмотреть команды животного");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("4. Выйти");
            System.out.print("Введите ваш выбор: ");
    
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
    
            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите команды для животного: ");
                    String commands = scanner.nextLine();
                    System.out.print("Введите дату рождения животного: ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Выберите вид животного (Pet или PackAnimal): ");
                    String type = scanner.nextLine();
    
                    try {
                        if ("Pet".equalsIgnoreCase(type)) {
                            System.out.print("Выберите вид животного (Cat, Dog, Hamster): ");
                            String petType = scanner.nextLine();
                            addAnimal(new Pet(name, commands, birthDate, petType));
                        } else if ("PackAnimal".equalsIgnoreCase(type)) {
                            System.out.print("Выберите вид животного (Camel, Donkey, Horse): ");
                            String packAnimalType = scanner.nextLine();
                            addAnimal(new PackAnimal(name, commands, birthDate, packAnimalType));
                        } else {
                            System.out.println("Неверный тип животного. Попробуйте снова.");
                        }
                        
                       System.out.println("Животное добавлено в реестр."); 
                    } catch (Exception e) {
                        System.out.println("Произошло исключение: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    displayAnimalCommands(animalName);
                    break;
                case 3:
                    System.out.print("Введите имя животного: ");
                    String animalName2 = scanner.nextLine();
                    System.out.print("Введите новые команды для животного: ");
                    String newCommands = scanner.nextLine();
                    teachAnimalCommands(animalName2, newCommands);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Завершение программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        PetRegistry registry = new PetRegistry();
        registry.displayMenu();
    }
}


