package com.cwd.money.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.cwd.money.core.Delta
import com.cwd.money.mysql.DBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TableViewModel(application: Application): AndroidViewModel(application) {

    fun precessDelta(){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                Delta.findAll()
            }
        }
    }

    var tables:LiveData<List<String>> = flow<List<String>>{
                val tables = DBHelper.allTable()
                emit(tables)
            }.flowOn(Dispatchers.IO).catch { e-> e.printStackTrace() }
            .asLiveData()



}