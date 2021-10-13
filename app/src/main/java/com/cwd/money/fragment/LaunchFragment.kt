package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cwd.money.databinding.FragmentLaunchBinding

class LaunchFragment : Fragment{
    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    private var _binding:FragmentLaunchBinding? = null

    private val binding
                get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLaunchBinding.inflate(inflater)
        binding.myView.let {
            lifecycle.addObserver(it)
        }

        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}