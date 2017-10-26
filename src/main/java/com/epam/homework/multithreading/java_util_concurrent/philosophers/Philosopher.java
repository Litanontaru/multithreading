package com.epam.homework.multithreading.java_util_concurrent.philosophers;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {

    private String name;
    private Spoon firstSpoon;
    private Spoon secondSpoon;

    public Philosopher(String name, Spoon leftSpoon, Spoon rightSpoon) {
        this.name = name;
        this.firstSpoon = leftSpoon;
        this.secondSpoon = rightSpoon;
    }

    @Override
    public void run() {
        System.out.println(name + " thinking");

        while (true) {
            firstSpoon.use(this);
            secondSpoon.use(this);

            System.out.println(name + " eating");
            pause();
            System.out.println(name + " thinking");

            secondSpoon.release(this);
            firstSpoon.release(this);

            pause();
        }
    }

    private void pause() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}