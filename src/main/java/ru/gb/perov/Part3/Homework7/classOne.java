package ru.gb.perov.Part3.Homework7;

public class classOne {

    @Test
    public void test1() {
        System.out.println("This is the first test");
    }

    @Test (1)
    public void test2() {
        System.out.println("This is the second test, but it runs the first");
    }

    @BeforeSuite
    public void test3() {
        System.out.println("Testing starting...");
    }

    @AfterSuite
    public void test4() {
        System.out.println("Testing finishing...");
    }

    @Test (2)
    public void test5() {
        System.out.println("This is the fifth test, but it runs the second");
    }
// для проверки генерации RuntimeException раскомментируйте аннотацию и метод ниже

//    @AfterSuite
//    public void test6() {
//        System.out.println("Testing finishing...");
//    }
}