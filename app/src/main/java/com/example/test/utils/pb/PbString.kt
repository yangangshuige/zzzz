package com.example.test.utils.pb

object PbString {
    /**
     * 开关锁返回结果取值key: ACCSetResult
     * value:ACCOpenSuccess 开锁成功
     * value:ACCOpenAlready 已是开锁状态
     * value:ACCCloseSuccess 关锁成功
     * value:ACCCloseAlready 已是关锁状态
     */
    const val ACC_SET_RESULT = "ACCSetResult"
    const val ACC_OPEN = "ACCOpen"
    const val ACC_CLOSE = "ACCClose"
    const val ACC_OPEN_SUCCESS = "ACCOpenSuccess"
    const val ACC_OPEN_ALREADY = "ACCOpenAlready"
    const val ACC_CLOSE_SUCCESS = "ACCCloseSuccess"
    const val ACC_CLOSE_ALREADY = "ACCCloseAlready"
    /**
     * 解设防返回结果取值key: SSResult
     * value:SSetOpenSuccess 设防成功
     * value:SSetOpenAlready 已是设防状态
     * value:SSetCloseSuccess 解防成功
     * value:SSetCloseAlready 已是解防状态
     */
    const val SS_RESULT = "SSResult"
    const val SS_ENABLE = "SSEnable"
    const val SS_DISABLE = "SSDisable"
    const val SS_OPEN_SUCCESS = "SSetOpenSuccess"
    const val SS_OPEN_ALREADY = "SSetOpenAlready"
    const val SS_CLOSE_SUCCESS = "SSetCloseSuccess"
    const val SS_CLOSE_ALREADY = "SSetCloseAlready"


}

enum class ActionName(value: String) {
    ACCSet("ACCSet"),
    SecuritySet("SecuritySet"),
    BlePairingCodeSet("BlePairingCodeSet"),
    HDGet("HDGet"),
    HBGet("HBGet"),
    ParamGet("ParamGet"),
    GetDeviceInfo("GetDeviceInfo"),
    BatteryGet("BatteryGet"),
    DeletePhoneFeature("DeletePhoneFeature"),
    UpdateByBle("UpdateByBle"),
    WriteFirmData("WriteFirmData"),
    HDSet("HDSet"),
    DeviceRestart("DeviceRestart"),
    DeviceRTCSet("DeviceRTCSet"),
    BatteryLockSet("BatteryLockSet"),
    BikeReFactory("BikeReFactory"),
    FindBike("FindBike")
}
