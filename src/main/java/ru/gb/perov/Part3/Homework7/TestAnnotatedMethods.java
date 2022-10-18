/*
       Создать класс, который может выполнять «тесты».
       В качестве тестов выступают классы с наборами методов, снабженных аннотациями @Test. Класс,
        запускающий тесты, должен иметь статический метод start(Class testClass), которому в качестве
        аргумента передается объект типа Class. Из «класса-теста» вначале должен быть запущен метод с
        аннотацией @BeforeSuite, если он присутствует. Далее запускаются методы с аннотациями @Test, а
        по завершении всех тестов – метод с аннотацией @AfterSuite.
       К каждому тесту необходимо добавить приоритеты (int-числа от 1 до 10), в соответствии с которыми
        будет выбираться порядок их выполнения. Если приоритет одинаковый, то порядок не имеет
        значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в
        единственном экземпляре. Если это не так – необходимо бросить RuntimeException при запуске
        «тестирования»
*/

package ru.gb.perov.Part3.Homework7;

import java.lang.reflect.Method;

public class TestAnnotatedMethods {
    public static void main(String[] args) throws Exception {
        start(classOne.class);
    }

    public static void start(Class testClass) {
        int countBeforeSuit = 0;
        int countAfterSuit = 0;

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                countBeforeSuit++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                countAfterSuit++;
            }
            if (countAfterSuit > 1 || countBeforeSuit > 1) {
                System.out.println("\u001B[31m" + "There are several methods with annotations @BeforeSuite or @AfterSuit in Clacc «" + testClass.getName() + "»" + "\u001B[0m");
                throw new RuntimeException();
            }

        }

        if (countBeforeSuit == 1) {
            for (int i = 0; i < testClass.getDeclaredMethods().length; i++) {
                BeforeSuite annotationBS = testClass.getDeclaredMethods()[i].getAnnotation(BeforeSuite.class);
                if (annotationBS != null) {
                    try {
                        System.out.println("Method: " + testClass.getDeclaredMethods()[i] + " -\u001B[32m Priority: without" + "\u001B[0m");
                        testClass.getDeclaredMethods()[i].invoke(testClass.getDeclaredConstructor().newInstance());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (int priority = 1; priority <= 10; priority++) {
            for (Method method : testClass.getDeclaredMethods()) {
                Test annotationT = method.getAnnotation(Test.class);
                if (annotationT != null && priority == annotationT.value()) {
                    try {
                        System.out.println("Method: " + method + " -\u001B[32m Priority: " + annotationT.value() + "\u001B[0m");
                        method.invoke(testClass.getDeclaredConstructor().newInstance());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (countAfterSuit == 1) {
            for (int j = 0; j < testClass.getDeclaredMethods().length; j++) {
                AfterSuite annotationAS = testClass.getDeclaredMethods()[j].getAnnotation(AfterSuite.class);
                if (annotationAS != null) {
                    try {
                        System.out.println("Method: " + testClass.getDeclaredMethods()[j] + " -\u001B[32m Priority: without" + "\u001B[0m");
                        testClass.getDeclaredMethods()[j].invoke(testClass.getDeclaredConstructor().newInstance());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


