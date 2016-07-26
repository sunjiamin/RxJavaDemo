package com.jojo.jiaminsun.rxjavademo;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by 82328 on 2016/7/19.
 */

public class MainTest {

    public void rxJavaTest(){
        Subscription subscription = Observable.just("Hello subscription")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
        System.out.println(subscription.isUnsubscribed());
        subscription.unsubscribe();
        System.out.println(subscription.isUnsubscribed());
    }
}
