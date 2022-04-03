package com.cwd.money.vm

import androidx.lifecycle.ViewModel
import com.cwd.money.mysql.DBHelper
import com.cwd.money.mysql.table.DeltaViewInfo
import com.cwd.money.utils.wrapDelta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.sql.ResultSet

class DeltaViewModel: ViewModel()  {

    fun getDeltaInfo(): Flow<List<DeltaViewInfo>> {
        return flow {
            val sql = "select * from delta order by date desc"
            val list = mutableListOf<DeltaViewInfo>()
            val rs: ResultSet = DBHelper.st.executeQuery(sql)
            while (rs.next()){
                val info = rs.wrapDelta()
                list.add(info)
            }
            emit(list)
            rs.close()
        }.flowOn(Dispatchers.IO).catch{
            e->e.printStackTrace()
        }
    }

}