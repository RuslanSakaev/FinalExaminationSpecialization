package nursery.accounting.system;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetRegistry {
    private List<Animal> animals;
    private Counter counter;
    private String filename;
    
    public PetRegistry(String filename) {
        animals = new ArrayList<>();
        counter = new Counter();
        this.filename = filename;
        loadAnimalsFromFile();
    }
    
    public void viewAnimalTable() {
        System.out.println("Таблица с животными:");
        System.out.println("Имя\t\tТип\t\tКоманды\t\tДата рождения");

        for (Animal animal : animals) {
            String animalType;
            if (animal instanceof Pet) {
                animalType = "Pet";
            } else if (animal instanceof PackAnimal) {
                animalType = "PackAnimal";
            } else {
                animalType = "Неизвестный тип";
            }
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", animal.getName(), animalType, animal.getCommands(), animal.getBirthDate());
        }
    }
    

    private void loadAnimalsFromFile() {
        PetFileWriter fileWriter = new PetFileWriter();
        animals = fileWriter.readFromFile(filename);
        // Обновляем счетчик животных, учитывая количество загруженных из файла
        counter.setCount(animals.size());
    }

    private void saveDataToFile() {
        PetFileWriter fileWriter = new PetFileWriter();
        fileWriter.writeToFile(animals, filename);
        System.out.println("Данные успешно сохранены в файл.");
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
    
    private void removeAnimal(String animalName) {
        Animal removedAnimal = null;
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                removedAnimal = animal;
                break;
            }
        }
        if (removedAnimal != null) {
            animals.remove(removedAnimal);
            counter.remove();
            System.out.println("Животное " + animalName + " успешно удалено из реестра.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private void editAnimal(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Введите новое имя животного: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новые команды для животного: ");
                    String newCommands = scanner.nextLine();
                    animal.setName(newName);
                    animal.setCommands(newCommands);
                    System.out.println("Запись о животном успешно отредактирована.");
                    return;
                }
            }
        }
        System.out.println("Животное не найдено.");
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Посмотреть команды животного");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("4. Вывести список всех животных");
            System.out.println("5. Удалить запись о животном");
            System.out.println("6. Редактировать запись о животном");
            System.out.println("7. Выйти");
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
                    viewAnimalTable();
                    break;
                case 5:
                    System.out.print("Введите имя животного для удаления: ");
                    String animalNameToDelete = scanner.nextLine();
                    removeAnimal(animalNameToDelete);
                    break;
                case 6:
                    System.out.print("Введите имя животного для редактирования: ");
                    String animalNameToEdit = scanner.nextLine();
                    editAnimal(animalNameToEdit);
                    break;
                case 7:
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
        String filename = "pets.txt"; // Имя файла для хранения данных
        PetRegistry registry = new PetRegistry(filename);
        registry.displayMenu();
        registry.saveDataToFile();
    }

}


