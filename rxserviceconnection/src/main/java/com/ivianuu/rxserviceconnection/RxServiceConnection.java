/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.rxserviceconnection;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Binds and unbinds services
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
                            // we do not call on complete
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
