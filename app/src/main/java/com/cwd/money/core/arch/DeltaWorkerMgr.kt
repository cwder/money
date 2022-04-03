package com.cwd.money.core.arch

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.work.*
import java.util.*

object DeltaWorkerMgr {

    lateinit var workId: UUID
    lateinit var delatRequest: WorkRequest

    fun getState(ctx: Context,length:Int): LiveData<WorkInfo> {
        val data = Data.Builder().putInt("bLine",length).build()
        delatRequest = OneTimeWorkRequestBuilder<DeltaWorker>()
            .setInputData(data)
            .build()
        workId = delatRequest.id
        return WorkManager.getInstance(ctx).getWorkInfoByIdLiveData(workId!!)
    }


    fun begin(ctx: Context){
        WorkManager.getInstance(ctx).enqueue(delatRequest)
    }
}