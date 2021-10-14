package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cwd.money.databinding.FragTabBinding

class MainFragment:Fragment() {

    private var _bind:FragTabBinding? = null

    /**
     * 这里用var会报错，未初始化，set，get里用到了field，必须外面赋值
     */
    private val bind:FragTabBinding
                get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bind = FragTabBinding.inflate(inflater)
        return bind.root
    }
}