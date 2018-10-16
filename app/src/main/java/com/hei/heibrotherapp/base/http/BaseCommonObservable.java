package com.hei.heibrotherapp.base.http;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName: BaseCommonObservable
 * @Description: java类作用描述
 * @Author: dongchang.Tang
 * @Date: 2018/10/16 15:59
 */

public abstract class BaseCommonObservable<T> implements Observer<BaseCommonResult<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        onStart();
    }

    @Override
    public void onNext(BaseCommonResult<T> tBaseResult) {
        onSuccess(tBaseResult);
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
        onFinish();
    }

    @Override
    public void onComplete() {

    }


    abstract void onStart();
    abstract void onSuccess(BaseCommonResult<T> tBaseResult);
    abstract void onFail(Throwable e);
    abstract void onFinish();
}
