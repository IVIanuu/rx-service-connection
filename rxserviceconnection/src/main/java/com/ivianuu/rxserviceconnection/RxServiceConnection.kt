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

package com.ivianuu.rxserviceconnection

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import io.reactivex.Observable

/**
 * Binds and unbinds [Service]'s via [Observable]'s
 */
object RxServiceConnection {

    @JvmStatic
    @JvmOverloads
    fun <T : Service> bind(
        context: Context,
        intent: Intent,
        flag: Int = Context.BIND_AUTO_CREATE
    ): Observable<T> {
        var bound = false
        return Observable.create { e ->
            val serviceConnection = object : ServiceConnection {
                override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
                    val rxBinder = iBinder as? RxBinder<T>
                            ?: throw IllegalStateException("binder must be an rx binder")
                    e.onNext(rxBinder.service)
                }

                override fun onServiceDisconnected(componentName: ComponentName) {
                    e.onComplete()
                }
            }

            e.setCancellable {
                if (bound) {
                    context.unbindService(serviceConnection)
                }
            }

            // bind the service
            bound = context.bindService(intent, serviceConnection, flag)
        }
    }
}
