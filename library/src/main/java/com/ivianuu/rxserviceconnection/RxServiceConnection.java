package com.ivianuu.rxserviceconnection;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public final class RxServiceConnection {

    private RxServiceConnection() {}

    public static <T extends Service> Observable<T> bind(@NonNull Context context, @NonNull Intent intent) {
        return bind(context, intent, Context.BIND_AUTO_CREATE);
    }

    public static <T extends Service> Observable<T> bind(@NonNull final Context context, @Nullable final Intent intent, final int flag) {
        return new Observable<T>() {

            private boolean bound;
            private boolean disposed;

            @Override
            protected void subscribeActual(final Observer<? super T> observer) {
                final ServiceConnection serviceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        RxBinder<T> rxBinder = (RxBinder<T>) iBinder;
                        if (!disposed) {
                            observer.onNext(rxBinder.getService());
                            // we do not call on compete
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {

                    }

                };

                observer.onSubscribe(new Disposable() {
                    @Override
                    public void dispose() {
                        if (bound) {
                            context.unbindService(serviceConnection);
                            disposed = true;
                        }
                    }

                    @Override
                    public boolean isDisposed() {
                        return disposed;
                    }
                });

                bound = context.bindService(intent, serviceConnection, flag);
            }
        };
    }
}
