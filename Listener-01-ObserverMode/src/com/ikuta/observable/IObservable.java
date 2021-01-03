package com.ikuta.observable;

import com.ikuta.observers.IObserver;

/**
 * 被观察者接口,即"可被观察的接口"
 */
public interface IObservable {
    void addObserver(IObserver observer);// 添加观察者

    void removeObserver(IObserver observer);// 删除观察者

    void notifyObservers(String message);// 像观察者发送信息
}
