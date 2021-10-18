package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cwd.money.R
import com.cwd.money.databinding.FragPointBinding
import com.cwd.money.utils.toast

class PointFragment:Fragment() {

    private lateinit var bind:FragPointBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.frag_point,container,false)

        bind.add.setOnClickListener {

        }
        return bind.root
    }


}