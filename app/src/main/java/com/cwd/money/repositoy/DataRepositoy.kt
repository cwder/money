package com.cwd.money.repositoy

import com.cwd.money.network.IApiService
import com.cwd.money.request.bean.Share

class DataRepositoy {
    suspend fun getShare(code:String): List<Share> {
        return IApiService.service.requestGetShare(code,1,1000)
    }
}