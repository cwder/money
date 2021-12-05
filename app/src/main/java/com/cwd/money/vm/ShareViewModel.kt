package com.cwd.money.vm

import androidx.lifecycle.*
import com.cwd.money.repositoy.DataRepositoy
import com.cwd.money.request.bean.ShareRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ShareViewModel : ViewModel() {

    val shareData = MutableLiveData<List<ShareRequest>>()

    private val shareRepositoy by lazy {
        DataRepositoy()
    }




    fun reqGetShare(code:String){
        viewModelScope.launch {

            flow {
                val resp = shareRepositoy.getShare(code)
                emit(resp)
            }.flowOn(Dispatchers.IO)
             .catch { e->
                    e.printStackTrace()
             }.collect {
               //shareData.value = it.message
            }
        }
    }








}