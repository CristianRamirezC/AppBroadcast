package com.cristiandev.appbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager

class WiFiChangeReceiver: BroadcastReceiver() {
    var wifiStatus: String = ""
    override fun onReceive(context: Context?, intent: Intent?) {
        val isWifiEnabled =
            intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)

        when(isWifiEnabled) {
            WifiManager.WIFI_STATE_ENABLED -> wifiStatus = "Enabled"
            WifiManager.WIFI_STATE_DISABLED -> wifiStatus = "Disabled"
            WifiManager.WIFI_STATE_UNKNOWN -> wifiStatus = "Error"
        }
    }
}