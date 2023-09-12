package com.nisaefendioglu.banklist.utils

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.nisaefendioglu.banklist.model.Bank

object FirebaseAnalyticsUtils {
    fun logBankInformation(bankItem: Bank) {
        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.ITEM_NAME, bankItem.dc_BANKA_SUBE ?: "")
            param(FirebaseAnalytics.Param.ITEM_ID, bankItem.dc_BANK_KODU ?: "")
            param(FirebaseAnalytics.Param.ITEM_ID, bankItem.dc_ADRES ?: "")
        }
    }

}

