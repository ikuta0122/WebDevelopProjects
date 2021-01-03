package com.ikuta;

import com.ikuta.observable.IObservable;
import com.ikuta.observable.Observed;
import com.ikuta.observers.FirstObserver;
import com.ikuta.observers.IObserver;
import com.ikuta.observers.SecondObserver;

public class ObserverModeDemo {

    public static void main(String[] args) {
        // 创建被观察者
        IObservable some = new Observed();
        // 创建多个观察者
        IObserver firstObserver = new FirstObserver();
        IObserver secondObserver = new SecondObserver();
        // 被观察者添加观察者
        some.addObserver(firstObserver);
        some.addObserver(secondObserver);
        // 被观察者向所有观察者发送消息
        some.notifyObservers("全体起立");
        System.out.println("-------------------------------");
        // 被观察者删除指定的观察者
        some.removeObserver(firstObserver);
        // 被观察者向所有观察者发送消息
        some.notifyObservers("全体起立");
    }

}
