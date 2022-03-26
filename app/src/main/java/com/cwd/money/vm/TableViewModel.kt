package com.cwd.money.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.cwd.money.mysql.DBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TableViewModel(application: Application): AndroidViewModel(application) {

    var tables:LiveData<List<String>> = liveData<List<String>> {
        withContext(Dispatchers.IO){
            val tables = DBHelper.allTable()
            emit(tables)
        }
    }



}