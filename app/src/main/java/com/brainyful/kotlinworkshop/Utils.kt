package com.brainyful.kotlinworkshop

import android.content.Context
import android.widget.Toast

fun toastMsg(msg: String, context: Context) {
    val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
    toast.show()
}