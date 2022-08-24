package de.syntaxinstitut.budgiebreeder.ui.splashScreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.databinding.FragmentSplashScreenBinding

class SplashScreenFragment: Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToOneFragment())
        },2500)

        return binding.root
    }
}