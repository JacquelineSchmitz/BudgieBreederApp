package de.syntaxinstitut.budgiebreeder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import de.syntaxinstitut.budgiebreeder.R
import de.syntaxinstitut.budgiebreeder.databinding.FragmentFlirtboxBinding


class FlirtBoxFragment : Fragment(R.layout.fragment_flirtbox) {
    private lateinit var binding: FragmentFlirtboxBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flirtbox, container, false)

        return binding.root
    }
}