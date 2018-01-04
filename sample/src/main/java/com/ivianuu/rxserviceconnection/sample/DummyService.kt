package com.ivianuu.rxserviceconnection.sample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.annotation.IntDef
import android.util.Log

import com.ivianuu.rxserviceconnection.RxBinder

import java.util.concurrent.TimeUnit

import io.reactivex.Observable

/**
 * Dummy service
 */
class DummyService : Service() {

    private val binder = object : RxBinder<DummyService>() {
        override val service: DummyService
            get() = this@DummyService
    }

    fun test(): Observable<Long> {
        return Observable.interval(1000, TimeUnit.MILLISECONDS)
    }

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }
}
