package com.greendot.greendotmobilesdk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.greendot.greendotmobilesdk.databinding.FragmentGdSdkBinding

class GDSdkFragment : Fragment() {

    private lateinit var binding: FragmentGdSdkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGdSdkBinding.inflate(inflater, container, false)
        return binding.root
    }

}
