package com.nisaefendioglu.banklist.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build

val Context.isNetworkConnected: Boolean
    get() {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }

            else -> {
                val nwInfo = connectivityManager.activeNetworkInfo ?: return false
                nwInfo.isConnected
            }
        }
}

fun Context.openMap(address: String?) {
    if (this.isNetworkConnected && !address.isNullOrEmpty()) {
        val sanitizedAddress = Uri.encode(address)
        val uri = Uri.parse("geo:0,0?q=$sanitizedAddress")
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?q=$sanitizedAddress")
            )
            startActivity(webIntent)
        }
    }
}

