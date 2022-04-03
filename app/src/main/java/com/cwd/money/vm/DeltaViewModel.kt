package com.cwd.money.vm

import androidx.lifecycle.ViewModel
import com.cwd.money.mysql.table.DeltaInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeltaViewModel: ViewModel()  {

    fun getDeltaInfo(): Flow<List<DeltaInfo>> {
        return flow {
            val sql = "select * from delta order by date desc"
            //DBHelper.st.execute()
        }
    }

}