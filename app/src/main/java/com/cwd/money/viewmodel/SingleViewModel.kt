package com.cwd.money.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SingleViewModel  : ViewModel(){

    fun reqSingleShare(code:String){
        val result = liveData {
            emit("")
        }
//        viewModelScope.launch {
//
//            flow {
//                val resp = userRepository.reqPay(money, code,splitCount)
//                emit(resp)
//            }.flowOn(Dispatchers.IO)
//                .catch { e->
//                    e.printStackTrace()
//                }.collect {
//                    userLiveData.value = it
//                }
//        }
    }

}