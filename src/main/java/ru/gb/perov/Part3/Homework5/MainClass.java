package ru.gb.perov.Part3.Homework5;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ru.gb.perov.Part3.Homework5.Car.getCarsPlace;

/*
мы организуем гонки.
Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не
может одновременно заехать больше половины участников (условность).
Попробуйте все это синхронизировать.
Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения
этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями
недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.
Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
пакета java.util.concurrent
*/
public class MainClass {
    public static final int NUMBERS_OF_CARS = 4;
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBERS_OF_CARS+1);
    public static final Semaphore semaphore = new Semaphore(NUMBERS_OF_CARS / 2);
    public static Lock lockVictory = new ReentrantLock();


    public static void main(String[] args) {
        System.out.println("\u001B[32m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" + "\u001B[0m");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[NUMBERS_OF_CARS];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

//        for (int i = 0; i < cars.length; i++) {
//            new Thread(cars[i]).start();
//        }

        ExecutorService service = Executors.newFixedThreadPool(NUMBERS_OF_CARS);
        for (Car thisCar : cars) {
            service.submit(() -> new Thread(thisCar).start());
        }

        try {
            cyclicBarrier.await();
            System.out.println("\u001B[32m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" + "\u001B[0m");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        service.shutdown();

        while (getCarsPlace() < NUMBERS_OF_CARS) {      // хотел сделать какой-нибудь проверкой состояния service (что он, например, isShutdown
            continue;                                   // или число активных потоков =0, но что-то ничего не получилось... решил сравнить число участников
        }                                               // с числом разыгранных мест... для этого же цикл чуть выше поменял на текущий рабочий цикл... оказалось зря...

        System.out.println("\u001B[32m" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" + "\u001B[0m");
    }
}