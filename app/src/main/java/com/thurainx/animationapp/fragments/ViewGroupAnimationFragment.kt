package com.thurainx.animationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thurainx.animationapp.R
import com.thurainx.animationapp.databinding.FragmentViewGroupAnimationBinding
import com.thurainx.animationapp.extensions.show
import com.thurainx.animationapp.extensions.toggleVisibility

class ViewGroupAnimationFragment : Fragment() {

    private lateinit var _binding : FragmentViewGroupAnimationBinding
    val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentViewGroupAnimationBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       with(binding){
           btnFirst.setOnClickListener {
               it.toggleVisibility()
           }

           btnSecond.setOnClickListener {
               it.toggleVisibility()
           }

           btnThird.setOnClickListener {
               it.toggleVisibility()
           }

           btnReset.setOnClickListener {
               btnFirst.show()
               btnSecond.show()
               btnThird.show()
           }
       }
    }

}