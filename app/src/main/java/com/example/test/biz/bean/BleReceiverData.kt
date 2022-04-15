package com.example.test.biz.bean

import com.example.test.utils.pb.PbString
import com.google.gson.annotations.SerializedName

class BleReceiverData {
    @SerializedName("Data")
    val data: ReceiverData = ReceiverData()

    @SerializedName("Name")
    val name = ""

    @SerializedName("PbVersion")
    val pbVersion = ""

    @SerializedName("ReplySeqId")
    val replySeqId: Int = 0

    @SerializedName("SeqId")
    val seqId: Int = 0

    @SerializedName("Time")
    val time: String = ""

    override fun toString(): String {
        return "BleReceiverData(data=$data, name='$name', pbVersion='$pbVersion', replySeqId=$replySeqId, seqId=$seqId, time='$time')"
    }

    fun lockOpenState(): Boolean = PbString.ACC_OPEN == data.aCC

    fun lockCloseState(): Boolean = PbString.ACC_CLOSE == data.aCC

    fun lockOpenSuccess(): Boolean =
        PbString.ACC_OPEN_SUCCESS == data.output.aCCSetResult || PbString.ACC_OPEN_ALREADY == data.output.aCCSetResult

    fun lockCloseSuccess(): Boolean =
        PbString.ACC_CLOSE_SUCCESS == data.output.aCCSetResult || PbString.ACC_CLOSE_ALREADY == data.output.aCCSetResult

    fun securityOpenState(): Boolean = PbString.SS_ENABLE == data.securityState

    fun securityCloseState(): Boolean = PbString.SS_DISABLE == data.securityState

    fun securitySetOpenSuccess(): Boolean =
        PbString.SS_OPEN_SUCCESS == data.output.sSResult || PbString.SS_OPEN_ALREADY == data.output.sSResult

    fun securitySetCloseSuccess(): Boolean =
        PbString.SS_CLOSE_SUCCESS == data.output.sSResult || PbString.SS_CLOSE_ALREADY == data.output.sSResult
}

class ReceiverData {
    @SerializedName("Output")
    val output: Output = Output()

    @SerializedName("TrackId")
    val trackId: Int = 0

    @SerializedName("ACC")
    val aCC = ""

    @SerializedName("SecurityState")
    val securityState = ""

    @SerializedName("BikeSetSource")
    val bikeSetSource = ""

    @SerializedName("GT")
    val gT = ""

    @SerializedName("TriggerType")
    val triggerType = ""

    @SerializedName("BatEventType")
    val batEventType = ""

    @SerializedName("BatteryMv")
    val batteryMv: Int = 0

    @SerializedName("BatterySoc")
    val batterySoc: Int = 0

    override fun toString(): String {
        return "ReceiverData(output=$output, trackId=$trackId, aCC='$aCC', securityState='$securityState', bikeSetSource='$bikeSetSource', gT='$gT', triggerType='$triggerType', batEventType='$batEventType', batteryMv=$batteryMv, batterySoc=$batterySoc)"
    }

}

class Output {
    @SerializedName("ACC")
    val aCC = ""

    @SerializedName("BmsFault")
    val bmsFault: List<Any> = listOf()

    @SerializedName("ECUFault")
    val eCUFault: List<Any> = listOf()

    @SerializedName("MCFault")
    val mCFault: List<Any> = listOf()

    @SerializedName("ACCSetResult")
    val aCCSetResult = ""

    @SerializedName("SSResult")
    val sSResult = ""

    @SerializedName("BikeSetSource")
    val bikeSetSource = ""

    @SerializedName("BlePairingCodeSetResult")
    val blePairingCodeSetResult = ""

    @SerializedName("DPFR")
    val dPFR = ""

    @SerializedName("UpdateActionResult")
    val updateActionResult = ""

    @SerializedName("WriteFirmDataResult")
    val writeFirmDataResult = ""

    override fun toString(): String {
        return "Output(aCC='$aCC', bmsFault=$bmsFault, eCUFault=$eCUFault, mCFault=$mCFault, aCCSetResult='$aCCSetResult', sSResult='$sSResult', bikeSetSource='$bikeSetSource', blePairingCodeSetResult='$blePairingCodeSetResult', dPFR='$dPFR', updateActionResult='$updateActionResult', writeFirmDataResult='$writeFirmDataResult')"
    }


}
