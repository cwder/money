package com.cwd.money.repositoy

import com.cwd.money.network.apiService
import com.cwd.money.network.request.SingleShareRequest
import com.cwd.money.network.response.ApiListResp
import com.cwd.money.network.response.ApiResponse
import com.cwd.money.network.bean.ShareInfo

class DataRepositoy {
    suspend fun getShare(code: String): ApiResponse<ApiListResp<ShareInfo>> {

        return apiService.requestGetShare(SingleShareRequest(code,1,10))
    }
}