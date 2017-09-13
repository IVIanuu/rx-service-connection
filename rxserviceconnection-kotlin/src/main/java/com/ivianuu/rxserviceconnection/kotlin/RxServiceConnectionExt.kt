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

package com.ivianuu.rxserviceconnection.kotlin

import android.app.Service
import android.content.Context
import android.content.Intent
import android.support.annotation.CheckResult
import com.ivianuu.rxserviceconnection.RxServiceConnection
import io.reactivex.Observable

/**
 * Binds the service until the observable gets disposed
 * Emits only 1 time on service connected
 */
@CheckResult
fun <T : Service> Context.bind(intent: Intent): Observable<T> = RxServiceConnection.bind(this, intent)

/**
 * Binds the service until the observable gets disposed
 * Emits only 1 time on service connected
 */
@CheckResult
fun <T : Service> Context.bind(intent: Intent?, flag: Int): Observable<T> = RxServiceConnection.bind(this, intent, flag)