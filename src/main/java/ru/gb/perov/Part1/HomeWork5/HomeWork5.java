package ru.gb.perov.Part1.HomeWork5;

public class HomeWork5 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan Ivanovich", "Engineer", "ivan_ivanov@mailbox.com", "84951111111", 30000, 30);
        persArray[1] = new Person("Petrov Petr Petrovich", "Chief Engineer", "petr_petrov@mailbox.com", "84952222222", 40000, 45);
        persArray[2] = new Person("Sidorov Sidor Sidorovich", "Bodyguard", "sidor_sidorov@mailbox.com", "84953333333", 100000, 55);
        persArray[3] = new Person("Olgina Olga Olegovna", "Director", "olga_olgina@mailbox.com", "84954444444", 99000, 18);
        persArray[4] = new Person("Evgenieva Evgehia Evgenievna", "Account", "evgenia_evgenieva@mailbox.com", "84955555555", 98000, 19);

        listOld(persArray);
        listOldByMe(persArray);
    }
// метод, вызывающий стандартный override toString()
    public static void listOld(Person[] array) {
        for (Person person : array) {
            if (person.getAge() > 40) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

// но была задача "Внутри класса «Сотрудник» написать метод...", поэтому написал...
    public static void listOldByMe(Person[] array) {
        for (Person person : array) {
            if (person.getAge() > 40) {
                System.out.println(person.personToString());
            }
        }
    }
}