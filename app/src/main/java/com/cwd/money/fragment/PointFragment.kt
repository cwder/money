package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.cwd.money.R
import com.cwd.money.databinding.FragPointBinding
import com.cwd.money.utils.Util
import com.cwd.money.utils.toast
import com.cwd.money.vm.ShareViewModel

class PointFragment:Fragment() {

    private lateinit var bind:FragPointBinding
    private val model:ShareViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.frag_point,container,false)
        bind.shareVm = model
        bind.lifecycleOwner = this
        bind.add.setOnClickListener {
          model.getShare(bind.editText.text.toString())
        }
        return bind.root
    }


}