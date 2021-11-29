package com.cwd.money.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.cwd.money.repositoy.DataRepositoy
import com.cwd.money.request.bean.Share
import kotlinx.coroutines.launch

class ShareViewModel : ViewModel() {

    val result = liveData<List<Share>> {
        val value = shareRepositoy.getShare("code")
        emit(value)
    }

    private val shareRepositoy by lazy {
        DataRepositoy()
    }





}