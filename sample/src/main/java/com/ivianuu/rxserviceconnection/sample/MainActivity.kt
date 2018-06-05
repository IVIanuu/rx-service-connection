package com.ivianuu.rxserviceconnection.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ivianuu.rxserviceconnection.RxServiceConnection
import io.reactivex.disposables.Disposable

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
