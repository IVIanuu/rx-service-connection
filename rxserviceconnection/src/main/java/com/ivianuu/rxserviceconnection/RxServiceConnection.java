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
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/**
 * Binds and unbinds services
 */
public final class RxServiceConnection {

    private RxServiceConnection() {
        // no instances
    }

    /**
     * Binds the service until the observable gets disposed
     * Emits only 1 time on service connected
     */
    @CheckResult @NonNull
    public static <T extends Service> Observable<T> bind(@NonNull Context context, @NonNull Intent intent) {
        return bind(context, intent, Context.BIND_AUTO_CREATE);
    }

    /**
     * Binds the service until the observable gets disposed
     * Emits only 1 time on service connected
     */
    @CheckResult @NonNull
    public static <T extends Service> Observable<T> bind(@NonNull final Context context,
                                                         @Nullable final Intent intent,
                                                         final int flag) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            private boolean bound;
            @Override
            public void subscribe(final ObservableEmitter<T> e) throws Exception {
                final ServiceConnection serviceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        if (!e.isDisposed()) {
                            RxBinder<T> rxBinder = (RxBinder<T>) iBinder;
                            e.onNext(rxBinder.getService());
                            // we do not call on complete
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {

                    }

                };

                e.setCancellable(() -> {
                    if (bound) { context.unbindService(serviceConnection); }
                });

                // bind the service
                bound = context.bindService(intent, serviceConnection, flag);
            }
        });
    }
}
