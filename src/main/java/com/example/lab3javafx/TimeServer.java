package com.example.lab3javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer implements Subject {
    private int timeState = 0;
    private List<Observer> observers = new ArrayList<>();

    public TimeServer() {
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L;

        TimerTask task = new TimerTask() {
            public void run() {
                tick();
            }
        };

        timer.schedule(task, delay, period);
    }

    private void tick() {
        timeState++;
        notifyAllObserver();
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(timeState); // Передаем текущее состояние
        }
    }

    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }
}