package com.thurainx.animationapp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.fragment.findNavController
import com.thurainx.animationapp.R
import com.thurainx.animationapp.activities.NextActivity
import com.thurainx.animationapp.databinding.FragmentAnimationListBinding


class AnimationListFragment : Fragment() {

    private lateinit var _binding: FragmentAnimationListBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimationListBinding.inflate(inflater,container,false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnValueAnimator.setOnClickListener {
                findNavController().navigate(R.id.action_navAnimationList_to_valueAnimatorFragment)
            }

            btnViewGroupAnimation.setOnClickListener {
                findNavController().navigate(R.id.action_navAnimationList_to_navViewGroupAnimation)
            }

            btnCombineAnimation.setOnClickListener {
                findNavController().navigate(R.id.action_navAnimationList_to_navCombineAnimation)
            }

            btnSpringAnimation.setOnClickListener {
                findNavController().navigate(R.id.action_navAnimationList_to_navSpringAnimation)
            }

            btnNextActivity.setOnClickListener {
                startActivity(NextActivity.getIntent(requireContext()))
            }

            ivAnimationBall.setOnClickListener {
                val transitionPair = androidx.core.util.Pair.create(it,getString(R.string.transition_ball))
                val option = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(),transitionPair)
                val intent = NextActivity.getIntent(requireContext())
                startActivity(intent,option.toBundle())
            }


        }

    }

}