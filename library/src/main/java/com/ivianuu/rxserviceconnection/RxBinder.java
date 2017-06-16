package com.ivianuu.rxserviceconnection;

import android.app.Service;
import android.os.Binder;
import android.support.annotation.NonNull;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public abstract class RxBinder<T extends Service> extends Binder {
    @NonNull
    public abstract T getService();
}
