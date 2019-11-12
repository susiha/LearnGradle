package com.susiha;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RxJavaDemo1 {

    public static void main(String args[]){


        Flowable.create(new FlowableOnSubscribe<String>() {

            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {

            }
        }, BackpressureStrategy.LATEST).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
