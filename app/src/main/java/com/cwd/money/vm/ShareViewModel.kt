package com.cwd.money.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cwd.money.request.bean.Share

class ShareViewModel : ViewModel() {
    val share = MutableLiveData<Share>()



}