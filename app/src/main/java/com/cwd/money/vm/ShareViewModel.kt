package com.cwd.money.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cwd.money.repositoy.ShareRepositoy
import com.cwd.money.request.bean.Share
import kotlinx.coroutines.launch

class ShareViewModel : ViewModel() {
    val share = MutableLiveData<Share>()

    private val shareRepositoy by lazy {
        ShareRepositoy()
    }

    fun getShare(code:String){
        viewModelScope.launch {
            share.value = shareRepositoy.getShare(code)
        }
    }



}