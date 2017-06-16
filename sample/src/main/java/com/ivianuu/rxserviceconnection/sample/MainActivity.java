package com.ivianuu.rxserviceconnection.sample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disposable = RxServiceConnection.<DummyService>bind(this, new Intent(this, DummyService.class))
                .switchMap(new Function<DummyService, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(@NonNull DummyService dummyService) throws Exception {
                        // do something with the service
                        return dummyService.test();
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.d("dummy", String.valueOf(aLong));
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
