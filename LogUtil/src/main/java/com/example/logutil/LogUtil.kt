package com.example.logutil
import android.util.Log

object LogUtil {

    /**
     * Extension function to provide TAG value
     */
    inline val <reified T> T.TAG: String
        get() {
            return if (!T::class.java.isAnonymousClass) {
                val name = T::class.java.simpleName
                if (name.length <= 23) name else name.substring(0, 23) // first 23 chars
            } else {
                val name = T::class.java.name
                if (name.length <= 23) name else name.substring(
                    name.length - 23,
                    name.length
                ) // last 23 chars
            }
        }

    /**
     * Verbose
     */
    inline fun <reified T> T.logv(message: String) {
        Log.v(TAG, message)
    }

    /**
     * Info
     */
    inline fun <reified T> T.logi(message: String) {
        Log.i(TAG, message)
    }

    /**
     * Warn
     */
    inline fun <reified T> T.logw(message: String) {
        Log.w(TAG, message)
    }

    /**
     * Debug
     */
    inline fun <reified T> T.logd(message: String) {
        Log.d(TAG, message)
    }

    /**
     * Error
     */
    inline fun <reified T> T.loge(message: String) {
        Log.e(TAG, message)
    }

}