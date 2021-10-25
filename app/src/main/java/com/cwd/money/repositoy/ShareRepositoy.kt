package com.cwd.money.repositoy

import com.cwd.money.network.IApiService
import com.cwd.money.request.bean.Share

class ShareRepositoy {
    suspend fun getShare(code:String): Share {
        return IApiService.service.requestGetShare()
    }
}