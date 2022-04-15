package com.example.test.biz.pages.usb

import android.content.Context
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.showToast
import com.example.test.R
import com.example.test.databinding.FragmentUsbListBinding

class UsbListFragment : Fragment(R.layout.fragment_usb_list) {
    private lateinit var viewBinding: FragmentUsbListBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentUsbListBinding.bind(view)
        val usbManager = requireActivity().getSystemService(Context.USB_SERVICE) as UsbManager
        val list = usbManager.deviceList
        for ((key, value) in list) {
            showToast("value============${value.deviceName}")
        }
        if(list.isEmpty()){
            showToast("no usb device")
        }
    }
}