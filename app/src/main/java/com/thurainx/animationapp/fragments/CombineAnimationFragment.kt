package com.thurainx.animationapp.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import com.thurainx.animationapp.R
import com.thurainx.animationapp.databinding.FragmentCombineAnimationBinding
import com.thurainx.animationapp.extensions.hide
import com.thurainx.animationapp.extensions.setAnimationEndListener
import com.thurainx.animationapp.extensions.show
import com.thurainx.animationapp.extensions.toggleVisibility
import kotlin.math.hypot

class CombineAnimationFragment : Fragment() {
    private lateinit var _binding: FragmentCombineAnimationBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombineAnimationBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateCrossFade()
        binding.btnCircularReveal.setOnClickListener {
            animateCircularReveal()
        }
    }

    private fun animateCrossFade() {
        with(binding) {
            tvDummy.alpha = 0.0f
            tvDummy.show()

            tvDummy.animate()
                .alpha(1.0f)
                .setDuration(1000)
                .setListener(null)

            progressBarLoading.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .setAnimationEndListener {
                    progressBarLoading.hide()
                }
        }
    }

    private fun animateCircularReveal(){
        with(binding){
            val cx = tvDummy.width / 2
            val cy = tvDummy.height / 2

            val radius = hypot(cx.toDouble(),cy.toDouble()).toFloat()

            val anim = ViewAnimationUtils.createCircularReveal(
                tvDummy,
                cx,
                cy,
                radius,
                0.0f
            )

            anim.addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    tvDummy.hide()
                }
            })

            anim.duration = 1000
            anim.start()
        }
    }

}