package com.cwd.money.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cwd.money.databinding.FragLaunchBinding

class LaunchFragment : Fragment(){
    private var _binding:FragLaunchBinding? = null

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

        _binding = FragLaunchBinding.inflate(inflater)

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