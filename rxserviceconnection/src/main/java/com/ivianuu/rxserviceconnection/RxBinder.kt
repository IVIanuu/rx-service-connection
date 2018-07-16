package com.ivianuu.rxserviceconnection

import android.app.Service
import android.os.Binder

/**
 * [Binder] with a get [T] function
 */
abstract class RxBinder<out T : Service> : Binder() {
    abstract val service: T
}