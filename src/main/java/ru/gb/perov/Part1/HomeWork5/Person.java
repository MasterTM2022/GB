package ru.gb.perov.Part1.HomeWork5;

public class Person {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String FIO, String position, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void setSalary(int salary) {
        salary = salary < 0 ? Math.abs(salary) : salary;
        this.salary = salary;
    }

    public void setEmail(String email) {
        email = email.contains("@") ? email : "";
        email = email.contains(".") ? email : "";
        this.email = email;
    }

    public void setAge(int age) {
        age = age < 0 ? Math.abs(age) : age;
        age = Math.min(age, 150);
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void printPerson (Person person) {
        System.out.println("Фамилия, имя, отчество: " + person.FIO);
        System.out.println("Должность: " + person.position);
        System.out.println("E-mail: " + person.email);
        System.out.println("Телефон: " + person.phone);
        System.out.println("Зарплата: " + person.salary);
        System.out.println("Возвраст: " + person.age);
    }
    public String personToString() {
        return "Сотрудник{" +
                "ФИО='" + this.FIO + '\'' +
                ", должность='" + position + '\'' +
                ", email='" + email + '\'' +
                ", телефон='" + phone + '\'' +
                ", зарплата=" + salary +
                ", возврат=" + age +
                '}';
    }

    @Override
    public String toString() {
        return "Person{" +
                "FIO='" + FIO + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
