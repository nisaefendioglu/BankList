package com.nisaefendioglu.banklist.utils

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter("android:text")
fun text(textView: TextView, value: String?) {
    textView.text = value.takeIf { !it.isNullOrEmpty() } ?: "No Information \uD83D\uDEAB"
}

fun setTextViewText(value: String?, infoNotAvailable: String): String {
    return value.takeIf { !it.isNullOrEmpty() } ?: infoNotAvailable
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun View?.setVisibility(
    isVisible: Boolean,
    setAsGone: Boolean = true
) {
    this?.let {
        visibility =
            when {
                isVisible -> View.VISIBLE
                setAsGone -> View.GONE
                else -> View.INVISIBLE
            }
    }
}


