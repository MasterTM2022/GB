package ru.gb.perov.HomeWork6;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Черныш", 2020, 3450, 200, 0, true, "черно-белый");
        Cat cat2 = new Cat("Плюха", 2019, 2150, 200, 0, false, "рыжий");
        Cat cat3 = new Cat("Алиса", 2021, 1650, 200, 0, false, "серый");
        Dog dog1 = new Dog("Тузик", 2018, 8500, 500, 10, true, 550);
        Dog dog2 = new Dog("Барбос", 2017, 10500, 500, 10, true, 600);

        cat1.run(250);
        cat3.run(180);
        cat2.swim(20);

        dog1.swim(20);
        dog2.swim(5);

        System.out.println("Всего зарегистрировано котов: " + Cat.getCatCount());
        System.out.println("Всего зарегистрировано собак: " + Dog.getDogCount());
        System.out.println("Всего зарегистрировано всех животных: " + Animal.getAnimalCount());
    }
}
