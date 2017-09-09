package com.ivianuu.rxserviceconnection.sample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ivianuu.rxserviceconnection.RxServiceConnection;

import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;
    private DummyService dummyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disposable = RxServiceConnection.<DummyService>bind(this, new Intent(this, DummyService.class))
                .flatMap(dummyService -> {
                    Log.d("dummyservice", "service bound");
                    return dummyService.test();
                })
                .subscribe(aLong -> Log.d("dummyservice ", String.valueOf(aLong)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
