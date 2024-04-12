package com.jeandarwinnewmanrios.horoscapp.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.jeandarwinnewmanrios.horoscapp.R
import com.jeandarwinnewmanrios.horoscapp.databinding.FragmentLuckBinding
import com.jeandarwinnewmanrios.horoscapp.ui.core.listeners.OnSwipeTouchListener
import com.jeandarwinnewmanrios.horoscapp.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject


@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null //que siginifica _binding y binding en este caso?  //binding es una propiedad privada que devuelve el valor de _binding y _binding es una variable privada que es nula
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCardProvider: RandomCardProvider
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        preparePrediction()
        initListeners()
    }

    private fun preparePrediction() {
        val currentLuck = randomCardProvider.getLucky()
        currentLuck?.let { luck ->
            val currentPrediction = getString(luck.text)
            binding.tvLucky.text = currentPrediction
            binding.ivLuckyCard.setImageResource(luck.image)
            binding.tvShare.setOnClickListener {
                shareResult(currentPrediction)
            }
        }
    }

    private fun shareResult(prediction: String) {
        val sendIntent: Intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, prediction)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
//        binding.ivRulete.setOnClickListener {
//            spinRulete()
//        }

        binding.ivRulete.setOnTouchListener(object : OnSwipeTouchListener(requireContext()) {

            override fun onSwipeLeft() {
                spinRulete()
            }
            override fun onSwipeRight() {
                spinRulete()
            }
        })
    }

    private fun spinRulete() {
       val random = Random()
       val degrees = random.nextInt(1440).toFloat() + 360f
       val animator = ObjectAnimator.ofFloat(binding.ivRulete, View.ROTATION, 0f, degrees)
       animator.duration = 2000
       animator.interpolator = DecelerateInterpolator()
       animator.doOnEnd { slideCard() }
       animator.start()

    }

    private fun slideCard(){
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.ivReverse.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growCard()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Do nothing
            }
        })
        binding.ivReverse.startAnimation(slideUpAnimation)

    }

    private fun growCard() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Do nothing
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivReverse.isVisible = false
                showPrediction()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Do nothing
            }
        })
        binding.ivReverse.startAnimation(growAnimation)
    }

    private fun showPrediction() {
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000
        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Do nothing
            }

            override fun onAnimationEnd(animation: Animation?) {
               binding.clLuck.isVisible = false
               binding.clPrediction.isVisible = true

            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Do nothing
            }
        })

        binding.clLuck.startAnimation(disappearAnimation)
        binding.clPrediction.startAnimation(appearAnimation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}