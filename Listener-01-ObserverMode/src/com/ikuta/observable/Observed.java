package com.ikuta.observable;

import com.ikuta.observers.IObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class Observed implements IObservable {
    private List<IObserver> observers;// 声明观察者集合

    public Observed() {// 在被观察者对象创建的同时,创建观察者集合
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (IObserver observer : observers) {// 通知每一个观察者
            observer.handleNotify(message);
        }
    }

}
