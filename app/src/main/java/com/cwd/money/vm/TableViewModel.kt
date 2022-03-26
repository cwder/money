package com.cwd.money.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.cwd.money.mysql.MysqlHelper
import com.cwd.money.mysql.table.ShareInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.ktorm.dsl.from
import org.ktorm.dsl.select

class TableViewModel(application: Application): AndroidViewModel(application) {

    var tables:LiveData<List<String>> = liveData<List<String>> {
        withContext(Dispatchers.IO){
            val temp = mutableListOf<String>()
            for (row in MysqlHelper.database.from(ShareInfo).select()){
                temp.add(row[ShareInfo.code] as String)
            }
            emit(temp)
        }
    }



}