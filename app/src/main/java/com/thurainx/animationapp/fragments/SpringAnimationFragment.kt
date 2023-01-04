package com.thurainx.animationapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.thurainx.animationapp.R
import com.thurainx.animationapp.databinding.FragmentSpringAnimationBinding

class SpringAnimationFragment : Fragment() {
    private lateinit var _binding: FragmentSpringAnimationBinding
    private val binding get() = _binding

    var springForce: SpringForce? = null
    var horizontalPositionDifference = 0.0f
    var verticalPositionDifference = 0.0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpringAnimationBinding.inflate(inflater, container, false)
        return _binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setUp spring
        springForce = SpringForce(0.0f).apply {
            stiffness = SpringForce.STIFFNESS_MEDIUM
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        }

        val springAnimationX = SpringAnimation(
            binding.ivBall,
            DynamicAnimation.TRANSLATION_X
        ).setSpring(springForce)

        val springAnimationY = SpringAnimation(
            binding.ivBall,
            DynamicAnimation.TRANSLATION_Y
        ).setSpring(springForce)


        binding.ivBall.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    horizontalPositionDifference = motionEvent.rawX - (view?.x ?: 0.0f)
                    verticalPositionDifference = motionEvent.rawY - (view?.y ?: 0.0f)

                    springAnimationX.cancel()
                    springAnimationY.cancel()
                }
                MotionEvent.ACTION_MOVE -> {
                    view.x = motionEvent.rawX - horizontalPositionDifference
                    view.y = motionEvent.rawY - verticalPositionDifference

                }
                MotionEvent.ACTION_UP -> {
                    springAnimationX.start()
                    springAnimationY.start()
                }
            }

            true
        }
    }

}