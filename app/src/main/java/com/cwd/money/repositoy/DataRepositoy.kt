package com.cwd.money.repositoy

import com.cwd.money.network.IApiService
import com.cwd.money.network.apiService
import com.cwd.money.network.request.SingleShareRequest
import com.cwd.money.network.response.ApiResponse
import com.cwd.money.network.response.SingleShareResp
import com.cwd.money.request.bean.Share

class DataRepositoy {
    suspend fun getShare(code: String): ApiResponse {

        return apiService.requestGetShare(SingleShareRequest(code,1,10))
    }
}