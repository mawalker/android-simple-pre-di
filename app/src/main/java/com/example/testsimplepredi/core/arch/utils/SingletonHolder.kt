package com.example.testsimplepredi.core.arch.utils

import kotlin.RuntimeException

/**
 * This class provides thread safe singleton creation where the singleton has a parameter.
 *
 * Kotlin's built into language 'Object' is a thread safe singleton, but doesn't allow params.
 *
 * This requires getInstance(T) to be called first (usually from Application class)
 */
open class SingletonHolder<out T: Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(): T {
        if (instance != null){
            return instance as (T)
        }
        throw RuntimeException()
    }

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}