package com.akilincarslan.baseapp.utils.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

fun Activity.showToast(message:String) {
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}

fun <T> Activity.startActivity(targetClass: Class<T>,bundle: Bundle?=null) {
    val intent = Intent(this,targetClass)
    bundle?.let {intent.putExtras(it) }
    startActivity(intent)
}