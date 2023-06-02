package com.arthlimchiu.rottenbanana.core.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatcher: MyDispatchers)

enum class MyDispatchers {
    Default,
    IO
}