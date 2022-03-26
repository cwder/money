package com.cwd.money.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.cwd.money.mysql.DBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TableViewModel(application: Application): AndroidViewModel(application) {

//    var tables:LiveData<List<String>> = liveData<List<String>> {
//        withContext(Dispatchers.IO){
//            val tables = DBHelper.allTable()
//            emit(tables)
//        }
//    }

    var tables:LiveData<List<String>> = flow<List<String>>{
                val tables = DBHelper.allTable()
                emit(tables)
            }.flowOn(Dispatchers.IO).catch { e-> e.printStackTrace() }
            .asLiveData()



}