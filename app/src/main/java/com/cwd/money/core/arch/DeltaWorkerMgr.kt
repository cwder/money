package com.cwd.money.core.arch

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.work.*
import com.cwd.money.act.BaseActivity

object DeltaWorkerMgr {

    lateinit var request: OneTimeWorkRequest
    var length:Int = 100

    fun getLiveData(ctx: Context): LiveData<WorkInfo>{
        return WorkManager.getInstance(ctx).getWorkInfoByIdLiveData(request.id)
    }

    fun getState(ctx: Context,length:Int): LiveData<WorkInfo> {
        this.length = length
        request = build(length)
        return WorkManager.getInstance(ctx).getWorkInfoByIdLiveData(request.id)
    }

    fun build(length:Int):OneTimeWorkRequest{
        val data = Data.Builder().putInt("bLine",length).build()
        request =  OneTimeWorkRequestBuilder<DeltaWorker>()
            .setInputData(data)
            .build()
        return request
    }

    fun begin(ctx: BaseActivity){
        WorkManager.getInstance(ctx)
            .beginUniqueWork("unique",ExistingWorkPolicy.KEEP,request)
            .enqueue()

    }
}