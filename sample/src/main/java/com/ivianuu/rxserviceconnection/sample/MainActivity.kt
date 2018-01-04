package com.ivianuu.rxserviceconnection.sample

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import com.ivianuu.rxserviceconnection.RxServiceConnection

import io.reactivex.ObservableSource
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable = RxServiceConnection.bind<DummyService>(this,
                Intent(this, DummyService::class.java))
                .flatMap<Any> { dummyService ->
                    Log.d("dummyservice", "service bound")
                    dummyService.test()
                }
                .subscribe { Log.d("dummyservice", it.toString()) }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
