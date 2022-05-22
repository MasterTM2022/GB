package ru.gb.perov.Part1.HomeWork7;

public class Main {
    public static void main(String[] args) {
        Cat[] catHouse = {
                new Cat("Barsik", 5, true),
                new Cat("Chernysh", 6, true),
                new Cat("Plyuha", 8, true),
                new Cat("Alisa", 7, true),
                new Cat("Murchik", 4, true)
        };
        Plate[] plates = {
                new Plate(10, 120),
                new Plate(2, 120),
                new Plate(5, 120)
        };

        System.out.println("Pets before eating:");
        for (Cat cat : catHouse) {
            System.out.println(cat);
        }

        System.out.println("Plates before eating:");
        for (int i = 0; i < plates.length; i++) {
            System.out.println("№" + (i+1)+ " " + plates[i].info());
        }

        for (Cat cat : catHouse) {
            int numberPlate = (int) (Math.random() * plates.length);
            while (!cat.isSatiety()) {
                if (cat.eat(plates[numberPlate])) {
                    System.out.println(cat.getName() + " decrease food in plate " + (numberPlate+1) + " (-" + cat.getAppetite() + ")");
                    System.out.println("next cat...");
                    break;
                } else {
                    plates[numberPlate].increaseFood();
                }
            }
        }

        System.out.println("Pets after eating:");
        for (Cat cat : catHouse) {
            System.out.println(cat);
        }

        System.out.println("Plates after eating:");
        for (int i = 0; i < plates.length; i++) {
            System.out.println("№" + (i+1)+ " " + plates[i].info());
        }
    }
}
