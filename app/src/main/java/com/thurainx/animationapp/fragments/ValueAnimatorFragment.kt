package com.thurainx.animationapp.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thurainx.animationapp.R
import com.thurainx.animationapp.databinding.FragmentValueAnimatorBinding


class ValueAnimatorFragment : Fragment() {

    private lateinit var _binding: FragmentValueAnimatorBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentValueAnimatorBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            // value animator
            btnStart.setOnClickListener {
               val animation = ValueAnimator.ofFloat(0.0f,500.0f)
                animation.duration = 2000
                animation.addUpdateListener {
                    btnStart.translationX = it.animatedValue as Float
                }
                animation.start()
            }

            // object animator
            val objectAnimatorFade = ObjectAnimator.ofFloat(tvObjectAnimator,"alpha",0.0f,1.0f)
            objectAnimatorFade.duration = 1600

            val objectTranslationX = ObjectAnimator.ofFloat(tvObjectAnimator, "translationX", -500f, 0.0f)
            objectTranslationX.duration = 1600

            AnimatorSet().apply {
                play(objectAnimatorFade).with(objectTranslationX)
                start()
            }
        }
    }

}