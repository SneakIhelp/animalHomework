import animals.Animal;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        while(true){
            System.out.println("Выберите 1 команду из списка: add/list/exit");

            String commandString = scanner.next().trim().toUpperCase(Locale.ROOT);

            boolean isExist = false;
            for(CommandsData commandsData: CommandsData.values()){
                if(commandsData.name().equals(commandString)){
                    isExist = true;
                    break;
                }
            }

            if(!isExist){
                System.out.println(String.format("В списке нет команды: %s", commandString));
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandString);

            switch (commandsData){
                case ADD: {
                    System.out.println("Введите животное из списка: cat/dog/duck");
                    AnimalFactory animalFactory = new AnimalFactory();

                    String animalString = scanner.next().trim().toUpperCase(Locale.ROOT);
                    Animal animal = animalFactory.create(animalString);

                    while(animal == null){
                        System.out.println("Вы ввели тип животного которого нет в списке. Попробуйте ещё раз!");
                        animalString = scanner.next().trim().toUpperCase(Locale.ROOT);
                        animal = animalFactory.create(animalString);
                    }

                    animals.add(fillAnimalData(animal));
                    break;
                }

                case EXIT: {
                    System.exit(0);
                }

                case LIST: {
                    for(Animal animal: animals){
                        System.out.println(animal.toString());
                    }
                    break;
                }
            }
        }
    }

    private static Animal fillAnimalData(Animal animal) {
        System.out.println("Введите имя животного");
        animal.setName(scanner.next());

        System.out.println("Введите возраст животного");
        while (true) {
            String ageString = scanner.next();
            try {
                animal.setAge(Integer.parseInt(ageString));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный возраст. Попробуйте еще раз:");
            }
        }

        System.out.println("Введите вес животного");
        while (true) {
            String weightString = scanner.next();
            try {
                animal.setWeight(Integer.parseInt(weightString));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный вес. Попробуйте еще раз:");
            }
        }

        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());

        return animal;
    }
}