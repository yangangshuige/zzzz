package com.example.test.biz.pages.usb

import android.content.*
import android.os.*
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.databinding.FragmentUsbBinding

class UsbFragment : Fragment(R.layout.fragment_usb) {
    private lateinit var viewBinding: FragmentUsbBinding
    private var usbService: UsbService? = null
    private val mHandler: Handler =object :Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                UsbService.MESSAGE_FROM_SERIAL_PORT -> {
                    val data = msg.obj as String
//                    mActivity.get().display.append(data)
                    Log.d("UsbFragment","message from port=========$data")
                }
                UsbService.CTS_CHANGE -> Toast.makeText(
                   requireContext(),
                    "CTS_CHANGE",
                    Toast.LENGTH_LONG
                ).show()
                UsbService.DSR_CHANGE -> Toast.makeText(
                    requireContext(),
                    "DSR_CHANGE",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    private val usbConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(arg0: ComponentName, arg1: IBinder) {
            usbService = (arg1 as UsbService.UsbBinder).service
            usbService?.setHandler(mHandler)
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            usbService = null
        }
    }
    private val mUsbReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                UsbService.ACTION_USB_PERMISSION_GRANTED -> Toast.makeText(
                    context,
                    "USB Ready",
                    Toast.LENGTH_SHORT
                ).show()
                UsbService.ACTION_USB_PERMISSION_NOT_GRANTED -> Toast.makeText(
                    context,
                    "USB Permission not granted",
                    Toast.LENGTH_SHORT
                ).show()
                UsbService.ACTION_NO_USB -> Toast.makeText(
                    context,
                    "No USB connected",
                    Toast.LENGTH_SHORT
                ).show()
                UsbService.ACTION_USB_DISCONNECTED -> Toast.makeText(
                    context,
                    "USB disconnected",
                    Toast.LENGTH_SHORT
                ).show()
                UsbService.ACTION_USB_NOT_SUPPORTED -> Toast.makeText(
                    context,
                    "USB device not supported",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentUsbBinding.bind(view)
        setFilters()
        if (!UsbService.SERVICE_CONNECTED) {
            val bindingIntent = Intent(requireContext(), UsbService::class.java)
            requireActivity().bindService(bindingIntent, usbConnection, Context.BIND_AUTO_CREATE)
        }
        viewBinding.buttonSend1.setOnClickListener {
            val data = viewBinding.editText1.text.toString().toByteArray()
            usbService?.write(data)
        }
    }
    private fun setFilters() {
        val filter = IntentFilter()
        filter.addAction(UsbService.ACTION_USB_PERMISSION_GRANTED)
        filter.addAction(UsbService.ACTION_NO_USB)
        filter.addAction(UsbService.ACTION_USB_DISCONNECTED)
        filter.addAction(UsbService.ACTION_USB_NOT_SUPPORTED)
        filter.addAction(UsbService.ACTION_USB_PERMISSION_NOT_GRANTED)
        requireActivity().registerReceiver(mUsbReceiver, filter)
    }
}