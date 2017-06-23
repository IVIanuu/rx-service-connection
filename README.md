# RxServiceConnection
A rxjava wrapper around the service connection api

## Introduction


## Download
```groovy
// in your root gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

```groovy
dependencies {
	 compile 'com.github.IVIanuu:RxServiceConnection:LATEST-VERSION'
}
```

## Usage

First create a service which returns a RxBinder<Service> instance.

```java
public class DummyService extends Service {

    private RxBinder<DummyService> binder = new RxBinder<DummyService>() {
        @NonNull
        @Override
        public DummyService getService() {
            return DummyService.this;
        }
    };
    
    ...

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}

```

Then to bind the service use this code.

```java
public class MainActivity extends AppCompatActivity {

    private Disposable disposable;
    private DummyService dummyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    
        ...

        disposable = RxServiceConnection.bind(this, new Intent(this, DummyService.class)) // bind the service
                .subscribe(service -> dummyService = service);
                
        // use the service
        dummyService.test()
                .subscribe(long -> {
                           // do something with data
                });
        
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose(); // service will be unbound if you dispose the observable
    }
}
```
To unbind the service simply dispose the observable

## License

```
Copyright 2017 Manuel Wrage

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
