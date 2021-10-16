package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cwd.money.databinding.FragAccessibilityBinding
import com.cwd.money.databinding.FragEarthBinding

class EarthFragment : Fragment() {
    private var _bind: FragEarthBinding? = null

    private val bind
        get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FragEarthBinding.inflate(inflater)
        val view = bind.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}