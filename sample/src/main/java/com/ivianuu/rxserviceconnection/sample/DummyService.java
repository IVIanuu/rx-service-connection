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

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(DummyService.class.getSimpleName(), "on create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(DummyService.class.getSimpleName(), "on start command");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(DummyService.class.getSimpleName(), "on destroy");
    }

    public Observable<Long> test() {
        return Observable.interval(1000, TimeUnit.MILLISECONDS);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
