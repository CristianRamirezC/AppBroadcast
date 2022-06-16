package com.cristiandev.appbroadcast

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cristiandev.appbroadcast.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    var wifiReceiver: WiFiChangeReceiver = WiFiChangeReceiver()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnCheckConn.setOnClickListener {
            binding.tvWiFiStatus.text = wifiReceiver.wifiStatus
            binding.tvMobileDataStatus.text = "Mobile Data"
        }
    }

    override fun onResume() {
        super.onResume()
         activity?.registerReceiver(wifiReceiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}