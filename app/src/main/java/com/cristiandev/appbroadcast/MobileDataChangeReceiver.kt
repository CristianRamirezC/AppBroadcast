package com.cristiandev.appbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class MobileDataChangeReceiver: BroadcastReceiver() {
    var mobileDataStatus: String = ""
    override fun onReceive(context: Context?, intent: Intent?) {
        val isMobileDataEnabled =
            intent?.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)
        mobileDataStatus = if(!isMobileDataEnabled!!) {
            "Enabled"
        }else{
            "Disabled"
        }
    }
}