package com.ivianuu.rxserviceconnection.sample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ivianuu.rxserviceconnection.RxBinder;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class DummyService extends Service {

    private RxBinder<DummyService> binder = new RxBinder<DummyService>() {
        @NonNull
        @Override
        public DummyService getService() {
            return DummyService.this;
        }
    };

    public Observable<Long> test() {
        return Observable.interval(1000, TimeUnit.MILLISECONDS);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
